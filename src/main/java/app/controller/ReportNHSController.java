package app.controller;

import app.domain.model.Company;
import app.domain.model.Sample;
import app.domain.model.State;
import app.domain.model.Test;
import app.domain.store.ClientStore;
import app.domain.store.TestStore;
import app.domain.utils.DemoFile;
import app.domain.utils.LinearRegression;
import app.domain.utils.OLSMultipleLinearRegression;
import com.nhs.report.Report2NHS;
import com.sun.javafx.binding.StringFormatter;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAmount;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Formatter;
import java.util.List;

public class ReportNHSController {

    Company company;
    TestStore testStore;
    List<Test> testeDias;
    ClientStore clientStore;
    String[][] TinNumberList;
    public ReportNHSController() {
        this.company = App.getInstance().getCompany();
        this.testStore = company.getTestStore();
        this.clientStore = company.getClientStore();

    }

    public boolean LinearRegression(int historicalPoints,String dataIni, String dataFim){
        String result = "";
        //guarda os testes neste intervalo de dias
         testeDias = testStore.getTestbyInterval(dataIni,dataFim);
         if(testeDias.size()>0){
             TinNumberList = new String[testeDias.size()][testeDias.size()] ;
             double[] nrTestDay = getTestDia();
             double[] nrPositiveDay = getPositiveTest();
             result +="The regression model fitted using data from the interval\n";
             LinearRegression lin = new LinearRegression(nrTestDay,nrPositiveDay);
             result +=lin.toString() + "\n";
             result +="// \n";
             result +="Other statistics\n";
             result +="R= "+lin.getR() +"\n";
             result +="R^2= "+lin.getR()*lin.getR() +"\n";
             result += "Hypothesis tests for regression coefficients\n HO:b=0 (a=0) H1: b<>0 (a<>0)\n";
             result += "t_obs=" + lin.getTCalculatedOfA() +"\n";
             if (lin.getTCalculatedOfA()>lin.getTTabela(25,0.05)){
                 result+="Reject H0\n//\n";
             }else{
                 result+="No reject H0\n//\n";
             }
             result +="Significance model with Anova\n H0: b=0  H1:b<>0";
             result += "\t\tdf\t\tSS\t\tMS\t\tF\n";
             result +="Regression\t1\t"+lin.getSqRegresion()+"\t"+lin.getMsr()+"\t"+lin.getEstatTest()+"\n";
             result +="Residual\t"+(testeDias.size()-2)+"\t"+lin.getSqResidual()+"\t"+lin.getMse()+"\n";
             result +="Total"+ (testeDias.size()-1)+"\t"+lin.getSqTotal()+"\n\n";
             result +="// Prediction values\n\n";
             result +="Date \t Number of OBSERVED positive cases  \t  Number of ESTIMATED positive cases \t 95% intervals\n";

             List<Test> tempTestHist = testStore.getTestbyInterval((30-15)+"/05/2021","30/05/2021");
             double[] tempPosi = getPositiveTest(tempTestHist);
             for (int i=0; historicalPoints>i;i++){
                result+=(29-i)+"05"+"2021" + "\t" + tempPosi[i] +"\t"+ lin.predict(i)+ "\t" + lin.intervaloComf(i)+"\n";
             }

             Report2NHS.writeUsingFileWriter(result);
            return true;
         }
         return false;
    }

    public boolean MultLinearRegression(int historicalPoints,String dataIni, String dataFim){
        String result = "";
        /*testeDias = testStore.getTestbyInterval(dataIni,dataFim);
        if(testeDias != null){
            TinNumberList = new String[testeDias.size()][testeDias.size()] ;
            double[] nrTestDay = getTestDia();
            double[] nrPositiveDay = getPositiveTest();
            double[] mediaIdades = new double[nrTestDay.length];
            for (int j=0; nrTestDay.length>j;j++){
                for(int i=0; nrTestDay[j]>i;i++){
                    mediaIdades[i]= clientStore.getMediaIdades(TinNumberList[i]);
                }
            }

            double[][] mediaIdadesPostivos= new double[nrTestDay.length][nrTestDay.length];
            for (int i=0; nrTestDay.length>i;i++){

                mediaIdadesPostivos[0][i]= mediaIdades[i];
                mediaIdadesPostivos[1][i]= nrPositiveDay[i];
                System.out.println("media :"+  mediaIdadesPostivos[0][i]);
                System.out.println("positivos :"+  mediaIdadesPostivos[1][i]);
            }*/
        double[][] x = {{80, 8}, {93, 9}, {100, 10}, {82, 12}, {90, 11}, {99, 8}, {81, 8}, {96, 10}, {94, 12}, {93, 11}, {97, 13}, {95, 11}};
        double[] y = {2256, 2340, 2426, 2293, 2330, 2368, 2250, 2409, 2364, 2379, 2440, 2364};

        result +="The regression model fitted using data from the interval\n";
            OLSMultipleLinearRegression mLin = new OLSMultipleLinearRegression();
            mLin.newSampleData(y,x);
            double[] beta = mLin.calculateBeta().toArray();
            result +="Y="+beta[0]+"+"+beta[1]+"X1 +"+beta[2]+"X2" + "\n";
            result +="// \n";
            result +="Other statistics\n";
            result +="R^2adjusted= "+mLin.calculateAdjustedRSquared() +"\n";
            result +="R^2= "+mLin.calculateRSquared() +"\n";
            result += "Hypothesis tests for regression coefficients\n HO:b=0 (a=0) H1: b<>0 (a<>0)\n";
            result += "t_obs=" + mLin.calculateT0() +"\n";
            if (mLin.calculateT0()>mLin.getTTabela(mLin.calculateDfResidual(), 0.975)){
                result+="Reject H0\n//\n";
            }else{
                result+="No reject H0\n//\n";
            }
            result +="Significance model with Anova\n H0: b=0  H1:b<>0";
            result += "\t\tdf\t\tSS\t\tMS\t\tF\n";
            result +="Regression\t1\t"+mLin.calculateDfRegression()+"\t"+mLin.calculateRegressionSumOfSquares()+"\t"+mLin.calculateMsRegression()+"\t"+mLin.calculateFo()+"\n";
            result +="Residual\t"+mLin.calculateDfResidual()+"\t"+mLin.calculateResidualSumOfSquares()+"\t"+mLin.calculateMsResidual()+"\n";
            result +="Total"+ mLin.calculateDfTotal()+"\t"+mLin.calculateTotalSumOfSquares()+"\n\n";
            result +="Descision: \n"+mLin.getF(0.05, mLin.calculateDfRegression(), mLin.calculateDfResidual())+"\n\n";
            if(mLin.calculateT0()>mLin.getF(0.05, mLin.calculateDfRegression(), mLin.calculateDfResidual())){
                result +="f0>f0.5, ("+mLin.calculateDfRegression()+"."+mLin.calculateDfResidual()+")="+mLin.getF(0.05, mLin.calculateDfRegression(), mLin.calculateDfResidual())+"\n";
                result +="Reject H0\n" + "The regression model is significant.";
            }else{
                result +="f0<f0.5, ("+mLin.calculateDfRegression()+"."+mLin.calculateDfResidual()+")="+mLin.getF(0.05, mLin.calculateDfRegression(), mLin.calculateDfResidual())+"\n";
                result +="Not Reject H0\n" ;
            }
            result +="// Prediction values\n\n";
            result +="Date \t Number of OBSERVED positive cases  \t  Number of ESTIMATED positive cases \t 95% intervals\n";

            List<Test> tempTestHist = testStore.getTestbyInterval((30-15)+"/05/2021","30/05/2021");
            double[] tempPosi = getPositiveTest(tempTestHist);

            double x1=0;
            double x2=0;
            double x3;



            for (int i=0; x.length>i;i++){
                x1+=beta[1]*x[i][0];
                x2+=beta[2]*x[i][1];
                x3= beta[0]+x1+x2;
                double[] horizontal = {1,x[i][1],x[i][1]};
                double[][] betaVariance = mLin.calculateBetaVariance().getData();
                double delta = mLin.calculateMsResidual()*(1+mLin.multiply3Matrix(horizontal,horizontal,betaVariance));
                double valor = mLin.multiply2Matrix(horizontal,beta);
                result+=(30-i)+"05"+"2021" + "\t" + x[i][1] +"\t"+ x3+ "\t" + mLin.calculateIntervalo(delta,valor)+"\n";

            }
            Report2NHS.writeUsingFileWriter(result);
            return true;
        }

    private double[] getPositiveTest(){
        double[] tempint = new double[testeDias.size()];
        for(int i=0; testeDias.size()>i;i++){
            tempint[i]=0;
            if(testeDias.get(i).getIgGan()>1.4){
                tempint[i]+=1;
            }

        }
        return tempint;
    }
    private double[] getPositiveTest(List<Test> tempTestHist){

        double[] tempint = new double[tempTestHist.size()];
        for(int i=0; tempTestHist.size()>i;i++){
            if(tempTestHist.get(i).getIgGan()>1.4){
                tempint[i]+=1;

            }
        }
        return tempint;
    }


    private double[] getTestDia(){
        double[] tempint = new double[testeDias.size()];
        for(int i=0; testeDias.size()>i;i++){
            tempint[i]=0;
            for(int j=i; testeDias.size()>j;j++){
                if(testeDias.get(i).getData(State.VALIDATED).substring(0,5).equals(testeDias.get(j).getData(State.VALIDATED).substring(0,5))){
                        tempint[i]+=1;//num test por dias
                        TinNumberList[i][i]=testeDias.get(i).getClientTinNum();

                }
            }
        }
        return tempint;
    }
}
