package app.controller;

import app.domain.model.*;
import app.domain.store.TestStore;
import app.domain.utils.DemoFile;

public class CreateDiagnosisReportController {
    private Company company;
    private DiagnosisReport rep;
    private TestStore testStore;

    public CreateDiagnosisReportController() {
        this.company = App.getInstance().getCompany();
        this.testStore = company.getTestStore();
        this.rep = null;
    }

    public boolean createReport(String report) {
        this.rep = this.testStore.createReport(report);
        return (this.rep != null);
    }

    public void saveReport(String code, String report) throws Exception {
        testStore.saveReport(testStore.getTest(code), new DiagnosisReport(report));
        DemoFile.writeFile(report,"Reports\\" + code);
    }

    public String getReadyTest(String code) {
        String temp = new String();
        for (TestParameterResult e: testStore.getTest(code).getTestParameterResult()) {
                temp +=  "Code ='" + code + '\'' +
                        "Result =" + e.getResult() +'\'' +
                        "Metric =" + e.getMetric() + '\'' +
                        "Ref value =" + e.getRefValue() + '\'' + ' ';

        }
        return temp;
    }

    public String getReadyTests() {
        String tempArray = new String();
        for (Test e:testStore.getTestsList(State.READY)) {
            tempArray += e.toStringReadyTests();
        }
        return tempArray;
    }

    public Test getTestByCode(String code){
        return testStore.getTest(code);
    }

}
