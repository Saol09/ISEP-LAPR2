package app.domain.utils;

import org.apache.commons.math3.distribution.FDistribution;
import org.apache.commons.math3.distribution.TDistribution;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.linear.*;
import org.apache.commons.math3.stat.StatUtils;
import org.apache.commons.math3.stat.descriptive.moment.SecondMoment;
import org.apache.commons.math3.stat.regression.AbstractMultipleLinearRegression;

/**
 * <p>
 * XT X b = XT y
 * <p>
 * XTX b = XT y
 * (QR)T (QR) b = (QR)Ty
 * RT (QTQ) R b = RT QT y
 * RT R b = RT QT y
 * (RT)-1 RT R b = (RT)-1 RT QT y
 * R b = QT y
 */
public class OLSMultipleLinearRegression extends AbstractMultipleLinearRegression {

    private QRDecomposition qr = null;



    private final double threshold;


    public OLSMultipleLinearRegression() {
        this(0d);
    }


    public OLSMultipleLinearRegression(final double threshold) {
        this.threshold = threshold;
    }


    public void newSampleData(double[] y, double[][] x) throws MathIllegalArgumentException {
        validateSampleData(x, y);
        newYSampleData(y);
        newXSampleData(x);
    }


    /**
     * by X(XTX)-1XT
     **/
    public RealMatrix calculateHat() {
        // Create augmented identity matrix
        RealMatrix Q = qr.getQ();
        final int p = qr.getR().getColumnDimension();
        final int n = Q.getColumnDimension();
        // No try-catch or advertised NotStrictlyPositiveException - NPE above if n < 3
        Array2DRowRealMatrix augI = new Array2DRowRealMatrix(n, n);
        double[][] augIData = augI.getDataRef();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j && i < p) {
                    augIData[i][j] = 1d;
                } else {
                    augIData[i][j] = 0d;
                }
            }
        }

        // Compute and return Hat matrix
        // No DME advertised - args valid if we get here
        return Q.multiply(augI).multiply(Q.transpose());
    }


    public double calculateTotalSumOfSquares() {
        if (isNoIntercept()) {
            return StatUtils.sumSq(getY().toArray());
        } else {
            return new SecondMoment().evaluate(getY().toArray());
        }
    }


    public double calculateResidualSumOfSquares() {
        final RealVector residuals = calculateResiduals();
        // No advertised DME, args are valid
        return residuals.dotProduct(residuals);
    }


    public double calculateRSquared() {
        return 1 - calculateResidualSumOfSquares() / calculateTotalSumOfSquares();
    }

    /**
     * R2adj = 1 - [SSR (n - 1)] / [SSTO (n - p)]
     **/
    public double calculateAdjustedRSquared() {
        final double n = getX().getRowDimension();
        if (isNoIntercept()) {
            return 1 - (1 - calculateRSquared()) * (n / (n - getX().getColumnDimension()));
        } else {
            return 1 - (calculateResidualSumOfSquares() * (n - 1)) /
                    (calculateTotalSumOfSquares() * (n - getX().getColumnDimension()));
        }
    }


    @Override
    protected void newXSampleData(double[][] x) {
        super.newXSampleData(x);
        qr = new QRDecomposition(getX(), threshold);
    }


    @Override
    public RealVector calculateBeta() {
        return qr.getSolver().solve(getY());
    }

    /**
     * Var(b) = (XTX)-1
     **/
    @Override
    public RealMatrix calculateBetaVariance() {
        int p = getX().getColumnDimension();
        RealMatrix Raug = qr.getR().getSubMatrix(0, p - 1, 0, p - 1);
        RealMatrix Rinv = new LUDecomposition(Raug).getSolver().getInverse();
        return Rinv.multiply(Rinv.transpose());
    }

    public double calculateRegressionSumOfSquares() {
        return calculateTotalSumOfSquares() - calculateResidualSumOfSquares();
    }

    public int calculateDfTotal() {
        int n = getX().getRowDimension();
        return n - 1;
    }

    public int calculateDfRegression() {
        int k = getX().getColumnDimension();
        return k - 1;
    }

    public int calculateDfResidual() {
        int n = getX().getRowDimension();
        int k = getX().getColumnDimension();
        return n - k;
    }

    public double calculateMsRegression() {
        double sqr = calculateRegressionSumOfSquares();
        double k = calculateDfRegression();
        return sqr/k;
    }

    public double calculateMsResidual() {
        double sqe = calculateResidualSumOfSquares();
        double x = calculateDfResidual();
        return sqe/x;
    }

    public double calculateFo(){
        return calculateMsRegression()/calculateMsResidual();
    }

    public double getF(double alphaFD, int n, int k){
        FDistribution fd= new FDistribution(n,k);
        double critFD= fd.inverseCumulativeProbability(1- alphaFD);

        return critFD;
    }
    public double getTTabela(int gl, double alphaTD){
        TDistribution td= new TDistribution(gl);
        double critTD;
        if(alphaTD> 0.5) {
            critTD = td.inverseCumulativeProbability(alphaTD);

        }
        else {
            critTD = td.inverseCumulativeProbability(1 - alphaTD);

        }
        return critTD;
    }

    public double multiply3Matrix(double[] horizontal, double[] vertical, double[][] central){
        int i=0;
        double[] newMatrixHorizontal={0,0,0};

        double result=0;
        int k=0;
        for(int j=0; j<horizontal.length;j++){
            for(i=0; i<horizontal.length; i++){
                newMatrixHorizontal[k] += horizontal[i]*central[j][i];
            }
            k++;
        }
        for(i=0; i<newMatrixHorizontal.length; i++){
            result += newMatrixHorizontal[i]*vertical[i];
        }
        return result;
    }

    public double multiply2Matrix(double[] horizontal, double[] vertical){
        int i=0;
        double result=0;
        int k=0;
        for(i=0; i<horizontal.length; i++){
            result += horizontal[i]*vertical[i];
        }
        return result;
    }


    public double getS(){
        return calculateBetaVariance().getEntry(2,2);
    }

    public double calculateT0(){
        double beta = calculateBeta().getEntry(2);
        System.out.println(beta);
        double raiz = Math.sqrt(getS()*calculateMsResidual());
        System.out.println(raiz);
        return beta/raiz;
    }

    public String calculateIntervalo(double delta, double valor){
        double limite = getTTabela(calculateDfResidual(),0.975)*Math.sqrt(delta);
        return  (valor-limite) + "-" +(valor+limite) ;
    }


}