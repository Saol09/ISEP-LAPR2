package app.domain.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class LinearRegressionTest {

    double[] x5= {20,16,34,23,27,32,18,22};
    double[] y5= {128,122,168,140,176,184,144,154};
    LinearRegression lin = new LinearRegression(x5,y5);

    @Test
    public void intercept() {
        String inte = "80.16326530612244";
        String inte2 = String.valueOf(lin.intercept());

        assertEquals(inte2,inte);
    }

    @Test
    public void slope() {
        String inte = "2.993197278911565";
        String inte2 = String.valueOf(lin.slope());

        assertEquals(inte2,inte);
    }

    @Test
    public void r2() {
        String inte = "0.7432318299780418";
        String inte2 = String.valueOf(lin.R2());

        assertEquals(inte2,inte);
    }

    @Test
    public void interceptStdErr() {
        String inte = "17.77910190184292";
        String inte2 = String.valueOf(lin.interceptStdErr());

        assertEquals(inte2,inte);
    }

    @Test
    public void slopeStdErr() {
        String inte = "0.7182376368844191";
        String inte2 = String.valueOf(lin.slopeStdErr());

        assertEquals(inte2,inte);
    }

    @Test
    public void predict() {
        String inte = "89.14285714285714";
        String inte2 = String.valueOf(lin.predict(3));

        assertEquals(inte2,inte);
    }

    @Test
    public void testToString() {
        String inte = "17.36738233359251";
        String inte2 = String.valueOf(lin.getEstatTest());

        assertEquals(inte2,inte);
    }

    @Test
    public void getX() {
        String inte = "24.0";
        String inte2 = String.valueOf(lin.getX());

        assertEquals(inte2,inte);
    }

    @Test
    public void getY() {
        String inte = "152.0";
        String inte2 = String.valueOf(lin.getY());

        assertEquals(inte2,inte);
    }

    @Test
    public void getSxy() {
        String inte = "880.0";
        String inte2 = String.valueOf(lin.getSxy());

        assertEquals(inte2,inte);
    }

    @Test
    public void getSxx() {
        String inte = "294.0";
        String inte2 = String.valueOf(lin.getSxx());

        assertEquals(inte2,inte);
    }

    @Test
    public void getSyy() {
        String inte = "3544.0";
        String inte2 = String.valueOf(lin.getSyy());

        assertEquals(inte2,inte);
    }

    @Test
    public void getSvar1() {
        String inte = "0.5158653030373147";
        String inte2 = String.valueOf(lin.getSvar1());

        assertEquals(inte2,inte);
    }

    @Test
    public void getSvar0() {
        String inte = "316.0964644361146";
        String inte2 = String.valueOf(lin.getSvar0());

        assertEquals(inte2,inte);
    }

    @Test
    public void getMqResidual() {
        String inte = "151.6643990929705";
        String inte2 = String.valueOf(lin.getMqResidual());

        assertEquals(inte2,inte);
    }

    @Test
    public void getSqRegresion() {
        String inte = "2634.01360544218";
        String inte2 = String.valueOf(lin.getSqRegresion());

        assertEquals(inte2,inte);
    }

    @Test
    public void getSqResidual() {
        String inte = "909.9863945578231";
        String inte2 = String.valueOf(lin.getSqResidual());

        assertEquals(inte2,inte);
    }

    @Test
    public void getSqTotal() {
        String inte = "3544.000000000003";
        String inte2 = String.valueOf(lin.getSqTotal());

        assertEquals(inte2,inte);
    }

    @Test
    public void getMsr() {
        String inte = "2634.01360544218";
        String inte2 = String.valueOf(lin.getMsr());

        assertEquals(inte2,inte);
    }

    @Test
    public void getMse() {
        String inte = "151.6643990929705";
        String inte2 = String.valueOf(lin.getMse());

        assertEquals(inte2,inte);
    }

    @Test
    public void getEstatTest() {
        String inte = "17.36738233359251";
        String inte2 = String.valueOf(lin.getEstatTest());

        assertEquals(inte2,inte);
    }

    @Test
    public void getR() {
        String inte = "0.8621089432189187";
        String inte2 = String.valueOf(lin.getR());

        assertEquals(inte2,inte);
    }

    @Test
    public void getTTabela() {
        String inte = "2.0595385527533003";
        String inte2 = String.valueOf(lin.getTTabela(25,0.05));

        assertEquals(inte2,inte);
    }

    @Test
    public void getTCalculatedOfA() {
        String inte = "4.508847845560354";
        String inte2 = String.valueOf(lin.getTCalculatedOfA());

        assertEquals(inte2,inte);
    }

    @Test
    public void getTCalculatedOfB() {
        String inte = "4.1674191454175205";
        String inte2 = String.valueOf(lin.getTCalculatedOfB());

        assertEquals(inte2,inte);
    }

    @Test
    public void calculateS() {
        String inte = "12.315210071004493";
        String inte2 = String.valueOf(lin.calculateS());

        assertEquals(inte2,inte);
    }

}