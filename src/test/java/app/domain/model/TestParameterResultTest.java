package app.domain.model;

import com.example2.EMRefValue;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class TestParameterResultTest {

    TestParameterResult testParameterResult = new TestParameterResult("aaa", "bbb", new EMRefValue("11aa","aaa", 0.5,10.5, new Date()));

    @Test
    public void getMetric() {
        assertEquals(testParameterResult.getMetric(),"aaa");
    }

    @Test
    public void setMetric() {
        testParameterResult.setMetric("aaa");
        assertEquals(testParameterResult.getMetric(), "aaa");
    }

    @Test
    public void getResult() {
        assertEquals(testParameterResult.getResult(),"bbb");
    }

    @Test
    public void setResult() {
        testParameterResult.setResult("bbb");
        assertEquals(testParameterResult.getResult(),"bbb");
    }


    @Test
    public void getRefValue() {
        assertEquals(testParameterResult.getRefValue().toString(),new EMRefValue("11aa","aaa", 0.5,10.5, new Date()).toString());
    }

    @Test
    public void setRefValue() {
        testParameterResult.setRefValue(new EMRefValue("11aa","aaa", 0.5,10.5, new Date()));
        assertEquals(testParameterResult.getRefValue().toString(),new EMRefValue("11aa","aaa", 0.5,10.5, new Date()).toString());
    }

}