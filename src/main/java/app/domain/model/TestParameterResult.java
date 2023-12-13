package app.domain.model;

import app.domain.utils.SaveDate;
import com.example2.EMRefValue;

public class TestParameterResult {
    private String metric;
    private String result;
    private EMRefValue refValue;
    private final String data;

    public TestParameterResult(String metric, String result, EMRefValue refValue) {
        this.metric = metric;
        this.result = result;
        this.refValue = refValue;
        this.data= SaveDate.dataCreation();
    }

    public String getMetric() {
        return metric;
    }

    public void setMetric(String metric) {
        this.metric = metric;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public EMRefValue getRefValue() {
        return refValue;
    }

    public String getData() {
        return data;
    }

    public void setRefValue(EMRefValue refValue) {
        this.refValue = refValue;
    }

    @Override
    public String toString() {
        return "TestParameterResult{" +
                "metric='" + metric + '\'' +
                ", result='" + result + '\'' +
                ", refValue='" + refValue + '\'' +
                "}";
    }
}
