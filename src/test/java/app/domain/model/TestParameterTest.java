package app.domain.model;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TestParameterTest {


        Parameter parameter = new Parameter("12345", "Paulo", "desc", new ParameterCategory("12345", "name"));

    final TestParameter testParameter = new TestParameter("12345", parameter);

    @Test
    public void getTestCode() {
        assertEquals("12345", testParameter.getTestCode());
    }

    @Test
    public void setTestCode() {
        testParameter.setTestCode("12225");
        assertEquals(testParameter.getTestCode(), "12225");
    }

    @Test
    public void getParameters() {
        assertEquals(parameter, testParameter.getParameters());
    }

    @Test
    public void setParameters() {
            Parameter parameter2 = new Parameter("12345", "Paulo", "desc", new ParameterCategory("12345", "name"));

        testParameter.setParameters(parameter2);
    }

    @Test
    public void testtoString(){
        try{
            assertEquals(testParameter.toString(),"TestParameter{testCode='12345', parameters=Parameter{code='12345', name='Paulo', desc='desc', category code='12345', category name='name'}}");
        }catch (Exception e){
            assertFalse(true);
        }
    }


}