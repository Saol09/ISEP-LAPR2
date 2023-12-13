package app.domain.utils;


/******************************************************************************
 *  Compute least squares solution to y = beta * x + alpha.
 *  Simple linear regression.
 ******************************************************************************/

import org.apache.commons.math3.distribution.TDistribution;

/**
 *  The code LinearRegression class performs a simple linear regression
 *  on an set of n data points (y_i, x_i).
 *  That is, it fits a straight line y = alpha + beta * x,
 *  (where y is the response variable, x is the predictor variable,
 *  alpha is the y-intercept, and beta is the slope)
 *  that minimizes the sum of squared residuals of the linear regression model.
 *  It also computes associated statistics, including the coefficient of
 *  determination R^2 and the standard deviation of the
 *  estimates for the slope and y-intercept.
 *
 */
public class LinearRegression {
    private final double intercept, slope;
    private final double r2;
    private final double svar0, svar1;
    private double xbar, ybar;
    private double rss, ssr;
    private double xxbar , yybar , xybar;
    private double svar;
    private double degreesOfFreedom;
    private int n;

    /**
     * Performs a linear regression on the data points (y[i], x[i]).
     *
     * @param  x the values of the predictor variable
     * @param  y the corresponding values of the response variable
     * @throws IllegalArgumentException if the lengths of the two arrays are not equal
     */
    public LinearRegression(double[] x, double[] y) {
        if (x.length != y.length) {
            throw new IllegalArgumentException("array lengths are not equal");
        }
        n = x.length;

        // first pass
        double sumx = 0.0, sumy = 0.0, sumx2 = 0.0;
        for (int i = 0; i < n; i++) {
            sumx  += x[i];
            sumx2 += x[i]*x[i];
            sumy  += y[i];
        }
        xbar = sumx / n;
        ybar = sumy / n;

        // second pass: compute summary statistics
        xxbar = 0.0;
        yybar = 0.0;
        xybar = 0.0;
        for (int i = 0; i < n; i++) {
            xxbar += (x[i] - xbar) * (x[i] - xbar);
            yybar += (y[i] - ybar) * (y[i] - ybar);
            xybar += (x[i] - xbar) * (y[i] - ybar);
        }
        slope  = xybar / xxbar;
        intercept = ybar - slope * xbar;

        // more statistical analysis
        rss = 0.0;      // residual sum of squares
        ssr = 0.0;      // regression sum of squares
        for (int i = 0; i < n; i++) {
            double fit = slope*x[i] + intercept;
            rss += (fit - y[i]) * (fit - y[i]);
            ssr += (fit - ybar) * (fit - ybar);
        }

        degreesOfFreedom = n-2;
        r2    = ssr / yybar;
        svar  = rss / degreesOfFreedom;
        svar1 = svar / xxbar;
        svar0 = svar/n + xbar*xbar*svar1;
    }

    /**
     * Returns the y-intercept alpha of the best of the best-fit line y = alpha + beta * x.
     *
     * @return the y-intercept alpha of the best-fit line y = alpha + beta * x
     */
    public double intercept() {
        return intercept;
    }

    /**
     * Returns the slope beta of the best of the best-fit line y = alpha + beta * x.
     *
     * @return the slope beta of the best-fit line y = alpha + beta * x
     */
    public double slope() {
        return slope;
    }

    /**
     * Returns the coefficient of determination R^2.
     *
     * @return the coefficient of determination R^2,
     *         which is a real number between 0 and 1
     */
    public double R2() {
        return r2;
    }

    /**
     * Returns the standard error of the estimate for the intercept.
     *
     * @return the standard error of the estimate for the intercept
     */
    public double interceptStdErr() {
        return Math.sqrt(svar0);
    }

    /**
     * Returns the standard error of the estimate for the slope.
     *
     * @return the standard error of the estimate for the slope
     */
    public double slopeStdErr() {
        return Math.sqrt(svar1);
    }

    /**
     * Returns the expected response y given the value of the predictor
     * variable x.
     *
     * @param  x the value of the predictor variable
     * @return the expected response y given the value of the predictor
     *         variable x
     */
    public double predict(double x) {
        return slope*x + intercept;
    }

    /**
     * Returns a string representation of the simple linear regression model.
     *
     * @return a string representation of the simple linear regression model,
     *         including the best-fit line and the coefficient of determination
     *         R^2
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(String.format("%.2f n + %.2f", slope(), intercept()));
        return s.toString();
    }

    public double getX(){
        return xbar;
    }

    public double getY(){
        return ybar;
    }

    public double getSxy(){
        return xybar;
    }

    public double getSxx(){
        return xxbar;
    }

    public double getSyy(){
        return yybar;
    }

    public double getSvar1(){
        return svar1;
    }

    public double getSvar0(){
        return svar0;
    }

    public double getMqResidual(){
        return svar;
    }

    public double getSqRegresion(){
        return ssr;
    }

    public double getSqResidual(){
        return rss;
    }

    public double getSqTotal(){
        return getSqResidual()+getSqRegresion();
    }

    public double getMsr(){
        return getSqRegresion();
    }

    public double getMse(){
        return getSqResidual()/(n-2);
    }

    public double getEstatTest(){
        return getSqRegresion()/getMqResidual();
    }

    public double getR(){
        return getSxy()/Math.sqrt(getSxx()*getSyy());
    }

    public double getTTabela(int gl, double alpha){
        TDistribution td= new TDistribution(gl);
        double alphaTD = alpha/2;
        double critTD;
        if(alphaTD> 0.5) {
            critTD = td.inverseCumulativeProbability(alphaTD);

        }
        else {
            critTD = td.inverseCumulativeProbability(1 - alphaTD);

        }
        return critTD;
    }

    public double getTCalculatedOfA(){
        double elevado = getX()*getX();
        double div = 1.0/n;
        double res = div+((elevado)/getSxx());
        double raiz = Math.sqrt(res);
        double div2 = 1.0/(n-2);
        double mul = div2*getSqResidual();
        double s = Math.sqrt(mul);
        return intercept/(s*raiz);
    }

    public double getTCalculatedOfB(){
        double res = 1.0/getSxx();
        double raiz = Math.sqrt(res);
        double s = calculateS();
        return slope/(s*raiz);
    }

    public double calculateS(){
        double div2 = 1.0/(n-2);
        double mul = div2*getSqResidual();
        return Math.sqrt(mul);
    }

    public String intervaloComf(int x) {
        double pred = predict(x);
        double s = calculateS();
        double t = getTTabela(n-2,0.1);
        double soma = 1+(1.0/n);
        double elevado = (x-getX())*(x-getX());
        double res = soma+((elevado)/getSxx());
        double raiz = Math.sqrt(res);
        double delta = s*t*raiz;
        double limInf = pred - delta;
        double limSup = pred + delta;
        return String.format(" %.2f - %.2f ", limInf,limSup);
    }


}
