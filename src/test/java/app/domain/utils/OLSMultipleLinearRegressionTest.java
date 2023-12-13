package app.domain.utils;

import org.apache.commons.math3.linear.RealVector;
import org.junit.Test;

import static org.junit.Assert.*;

public class OLSMultipleLinearRegressionTest {
    double[][] x = {{80, 8}, {93, 9}, {100, 10}, {82, 12}, {90, 11}, {99, 8}, {81, 8},{96, 10}, {94, 12}, {93, 11}, {97, 13}, {95, 11}};
    double[][] x1 = {{80, 8}, {93, 9}, {100, 10}, {82, 12}, {90, 11}, {99, 8}, {81, 8},
            {96, 11}, {94, 12}, {93, 11}, {97, 13}, {95, 11}};

    double[] y = {2256, 2340, 2426, 2293, 2330, 2368, 2250, 2409, 2364, 2379, 2440, 2364};

    OLSMultipleLinearRegression reg = new OLSMultipleLinearRegression();


    @Test
    public void newSampleData() {
        reg.newSampleData(y,x);
        assertNotNull(reg);
    }

    @Test
    public void calculateHat() {
        reg.newSampleData(y,x);
        String inte = "Array2DRowRealMatrix{{0.4146807658,0.1218978327,-0.0591608348,0.1745845793,0.0763325832,0.0608872584,0.3960600549,0.0153220088,-0.0488639517,0.0204704504,-0.1554397756,-0.0167709714},{0.1218978327,0.1453535572,0.1376411711,-0.0440135237,0.0416191386,0.2205968493,0.1270925178,0.1168624308,0.0183226973,0.0572031939,-0.0101684291,0.067592564},{-0.0591608348,0.1376411711,0.231967609,-0.125915878,0.0359466042,0.2653451306,-0.0420815735,0.1636505637,0.0790352581,0.0871843882,0.1050446507,0.1213429109},{0.1745845793,-0.0440135237,-0.125915878,0.4393234064,0.179486389,-0.2582852915,0.1518019546,-0.0347853788,0.165931909,0.1111385147,0.1751600538,0.0655732651},{0.0763325832,0.0416191386,0.0359466042,0.179486389,0.1125566483,-0.0156302987,0.0714924315,0.0553072109,0.1214045689,0.0980361932,0.1350926411,0.0883558899},{0.0608872584,0.2205968493,0.2653451306,-0.2582852915,-0.0156302987,0.4249314055,0.0800474766,0.1887042575,-0.0283626723,0.0418503561,-0.0602552641,0.0801707926},{0.3960600549,0.1270925178,-0.0420815735,0.1518019546,0.0714924315,0.0800474766,0.3794278139,0.0244473903,-0.047784937,0.0215957086,-0.1504300644,-0.0116687733},{0.0153220088,0.1168624308,0.1636505637,-0.0347853788,0.0553072109,0.1887042575,0.0244473903,0.1271490376,0.0747191993,0.0826833554,0.0850058061,0.1009341184},{-0.0488639517,0.0183226973,0.0790352581,0.165931909,0.1214045689,-0.0283626723,-0.047784937,0.0747191993,0.1788800855,0.124641613,0.2352765874,0.1267996424},{0.0204704504,0.0572031939,0.0871843882,0.1111385147,0.0980361932,0.0418503561,0.0215957086,0.0826833554,0.124641613,0.1014119678,0.1501217745,0.1036624842},{-0.1554397756,-0.0101684291,0.1050446507,0.1751600538,0.1350926411,-0.0602552641,-0.1504300644,0.0850058061,0.2352765874,0.1501217745,0.3304508226,0.1601411968},{-0.0167709714,0.067592564,0.1213429109,0.0655732651,0.0883558899,0.0801707926,-0.0116687733,0.1009341184,0.1267996424,0.1036624842,0.1601411968,0.1138668804}}";
        String inte2 = String.valueOf(reg.calculateHat());
        assertEquals(inte2,inte);
    }

    @Test
    public void calculateTotalSumOfSquares() {
        reg.newSampleData(y,x);
        String inte = "41468.91666666665";
        String inte2 = String.valueOf(reg.calculateTotalSumOfSquares());
        assertEquals(inte2,inte);
    }

    @Test
    public void calculateResidualSumOfSquares() {
        reg.newSampleData(y,x);
        String inte = "3245.356110819924";
        String inte2 = String.valueOf(reg.calculateResidualSumOfSquares());
        assertEquals(inte2,inte);
    }

    @Test
    public void calculateRSquared() {
        reg.newSampleData(y,x);
        String inte = "0.921740031529963";
        String inte2 = String.valueOf(reg.calculateRSquared());
        assertEquals(inte2,inte);
    }

    @Test
    public void calculateAdjustedRSquared() {
        reg.newSampleData(y,x);
        String inte = "0.9043489274255103";
        String inte2 = String.valueOf(reg.calculateAdjustedRSquared());
        assertEquals(inte2,inte);
    }

    @Test
    public void newXSampleData() {
        reg.newSampleData(y,x);
        OLSMultipleLinearRegression reg1 = new OLSMultipleLinearRegression();
        reg1.newSampleData(y,x);
        reg1.newXSampleData(x1);
        assertNotEquals(reg,reg1);
    }

    @Test
    public void calculateBetaVariance() {
        reg.newSampleData(y,x);
        String inte = "Array2DRowRealMatrix{{16.4449342829,-0.1614205999,-0.15265489},{-0.1614205999,0.00198847,-0.0020347134},{-0.15265489,-0.0020347134,0.0330897843}}";
        String inte2 = String.valueOf(reg.calculateBetaVariance());
        assertEquals(inte2,inte);
    }

    @Test
    public void calculateRegressionSumOfSquares() {
        reg.newSampleData(y,x);
        String inte = "38223.56055584673";
        String inte2 = String.valueOf(reg.calculateRegressionSumOfSquares());
        assertEquals(inte2,inte);
    }

    @Test
    public void calculateDfTotal() {
        reg.newSampleData(y,x);
        String inte = "11";
        String inte2 = String.valueOf(reg.calculateDfTotal());
        assertEquals(inte2,inte);
    }

    @Test
    public void calculateDfRegression() {
        reg.newSampleData(y,x);
        String inte = "2";
        String inte2 = String.valueOf(reg.calculateDfRegression());
        assertEquals(inte2,inte);
    }

    @Test
    public void calculateDfResidual() {
        reg.newSampleData(y,x);
        String inte = "9";
        String inte2 = String.valueOf(reg.calculateDfResidual());
        assertEquals(inte2,inte);
    }

    @Test
    public void calculateMsRegression() {
        reg.newSampleData(y,x);
        String inte = "19111.780277923364";
        String inte2 = String.valueOf(reg.calculateMsRegression());
        assertEquals(inte2,inte);
    }

    @Test
    public void calculateMsResidual() {
        reg.newSampleData(y,x);
        String inte = "360.595123424436";
        String inte2 = String.valueOf(reg.calculateMsResidual());
        assertEquals(inte2,inte);
    }

    @Test
    public void calculateFo() {
        reg.newSampleData(y,x);
        String inte = "53.000662062276355";
        String inte2 = String.valueOf(reg.calculateFo());
        assertEquals(inte2,inte);
    }

    @Test
    public void getF() {
        reg.newSampleData(y,x);
        String inte = "4.256494729093686";
        String inte2 = String.valueOf(reg.getF(0.05,reg.calculateDfRegression(),reg.calculateDfResidual()));
        assertEquals(inte2,inte);
    }

    @Test
    public void getTTabela() {
        reg.newSampleData(y,x);
        String inte = "2.262157162798239";
        String inte2 = String.valueOf(reg.getTTabela(reg.calculateDfResidual(),0.975));
        assertEquals(inte2,inte);
    }

    @Test
    public void multiply3Matrix() {
        reg.newSampleData(y,x);
        double[] horizontal = {1,80,8};
        double[] vertical = {1,80,8};
        double[][] central = new double [3][3];
        central[0]=reg.calculateBetaVariance().getRow(0);
        central[1]=reg.calculateBetaVariance().getRow(1);
        central[2]=reg.calculateBetaVariance().getRow(2);
        String inte = "0.41468076579215385";
        String inte2 = String.valueOf(reg.multiply3Matrix(horizontal,vertical,central));
        assertEquals(inte2,inte);
    }

    @Test
    public void multiply2Matrix() {
        reg.newSampleData(y,x);
        double[] horizontal = {1,80,8};
        double[] verticalBeta = reg.calculateBeta().toArray();
        String inte = "2241.9059715756703";
        String inte2 = String.valueOf(reg.multiply2Matrix(horizontal,verticalBeta));
        assertEquals(inte2,inte);
    }

    @Test
    public void getS() {
        reg.newSampleData(y,x);
        String inte = "0.03308978429982222";
        String inte2 = String.valueOf(reg.getS());
        assertEquals(inte2,inte);
    }

    @Test
    public void calculateT0() {
        reg.newSampleData(y,x);
        String inte = "2.840863946403265";
        String inte2 = String.valueOf(reg.calculateT0());
        assertEquals(inte2,inte);
    }

    @Test
    public void calculateIntervalo() {
        reg.newSampleData(y,x);
        String inte = "4.941662808195079-15.05833719180492";
        String inte2 = String.valueOf(reg.calculateIntervalo(5,10));
        assertEquals(inte2,inte);
    }
}