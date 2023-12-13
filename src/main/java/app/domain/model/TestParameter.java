package app.domain.model;

import java.util.List;

public class TestParameter {
    private String testCode;
    private Parameter parameters;

    public TestParameter(){}

    public TestParameter(String testCode, Parameter parameters) {
        this.testCode = testCode;
        this.parameters = parameters;
    }

    public String getTestCode() {
        return testCode;
    }

    public void setTestCode(String testCode) {
        this.testCode = testCode;
    }

    public Parameter getParameters() {
        return parameters;
    }

    public void setParameters(Parameter parameters) {
        this.parameters = parameters;
    }

    @Override
    public String toString() {
        return "TestParameter{" +
                "testCode='" + testCode + '\'' +
                ", parameters=" + parameters +
                '}';
    }
}
