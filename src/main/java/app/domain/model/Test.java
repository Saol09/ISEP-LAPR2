package app.domain.model;

import app.domain.utils.SaveDate;
import com.example2.ExternalModule2API;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {


    private String code;
    private String nhsCode;

    //private State state;
    private Map<State,String> state = new HashMap<>() ;

    private DiagnosisReport report;
    private List<TestParameter> testParameter = new ArrayList<>();
    private ClinicalAnalysisLab clinicalAnalysisLab;
    private TypeOfTest typeOfTest;
    private List<TestParameterResult> testParameterResult = new ArrayList<>();
    private String clientTinNum;
    private List<Sample> sampleList;
    private double IgGan;

    public ClinicalAnalysisLab getClinicalAnalysisLab() {
        return clinicalAnalysisLab;
    }

    public void setClinicalAnalysisLab(ClinicalAnalysisLab clinicalAnalysisLab) {
        this.clinicalAnalysisLab = clinicalAnalysisLab;
    }

    public Test() {
    }

    public double getIgGan() {
        return IgGan;
    }

    public void setIgGan(double igGan) {
        IgGan = igGan;
    }

    public Test(String code, String nhsCode, TypeOfTest typeOfTest, String clientTinNum, TestParameter testParameter) {
        this.code = code;
        this.nhsCode = nhsCode;
        this.state.put(State.NEW,SaveDate.dataCreation());
        this.typeOfTest = typeOfTest;
        this.clientTinNum = clientTinNum;
        this.testParameter.add(testParameter);
    }

    public Test(String code, String nhsCode, TypeOfTest typeOfTest, String clientTinNum, List<TestParameter> testParameter) {
        this.code = code;
        this.nhsCode = nhsCode;

        this.state.put(State.NEW,SaveDate.dataCreation());
        this.typeOfTest = typeOfTest;
        this.clientTinNum = clientTinNum;
        this.testParameter=testParameter;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNhsCode() {
        return nhsCode;
    }

    public void setNhsCode(String nhsCode) {
        this.nhsCode = nhsCode;
    }



    public Map<State,String> getState() {
        return state;
    }

    public String getData(State estado){
        return state.get(estado);
    }

    public boolean setState(State estado, String data) {
        this.state.put(estado,data);
        return true;
    }




    public DiagnosisReport getReport() {
        return report;
    }

    public void setReport(DiagnosisReport report) {
        this.report = report;
    }

    public void setTestParameter(TestParameter testParameter) {
        this.testParameter.add(testParameter);
    }

    public void setTypeOfTest(TypeOfTest typeOfTest) {
        this.typeOfTest = typeOfTest;
    }

    public void setClientTinNum(String clientTinNum) {
        this.clientTinNum = clientTinNum;
    }

    public List<TestParameter> getTestParameter() {
        return testParameter;
    }

    public TypeOfTest getTypeOfTest() {
        return typeOfTest;
    }

    public String getClientTinNum() {
        return clientTinNum;
    }


    public List<Sample> getSampleList() {
        return sampleList;
    }

    public void setSampleList(List<Sample> sampleList) {
        this.sampleList = sampleList;
        this.state.put(State.RECORDED,SaveDate.dataCreation());
    }

    public List<TestParameterResult> getTestParameterResult() {
        return testParameterResult;
    }

    public void setTestParameterResult(TestParameterResult testParameterResult) {
        this.testParameterResult.add(testParameterResult);
    }

    public boolean addTestResult(String parameterCode, String result, String metric) {
        try {
            ExternalModule2API api = new ExternalModule2API();
            this.testParameterResult.add(new TestParameterResult(metric, result, api.getReferenceFor(parameterCode)));
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Test[" +
                "code = " + code + '\'' +
                ", nhsCode = " + nhsCode + '\'' +
                ", state = " + state +
                ", report = " + report +

                ", typeOfTest = " + typeOfTest +
                ", testParameterResult = " + testParameterResult.toString() +
                ", clientTin = " + clientTinNum +
                ", sampleList = " + sampleList +
                ']';
    }

    public String toStringReadyTests() {
        return "Test" + "code = " + code + ", create at = "+this.state.get(State.NEW) + ", state = " + state+ "\n";

    }

    public String shortString() {

        return "Code: " + code + "Registation date: "+this.state.get(State.NEW) + "Chemical analysis date: " + this.state.get(State.READY) + " Diagnosis date: " + this.state.get(State.DIAGNOSED)+ "\n";
    }

    public String testString() {
        return "Code " + code + "\n";
    }
}
