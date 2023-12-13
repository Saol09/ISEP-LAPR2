package app.controller;

import app.domain.model.Company;
import app.domain.model.Sample;
import app.domain.model.State;
import app.domain.model.Test;
import app.domain.store.TestStore;

import java.util.ArrayList;
import java.util.List;

public class RecordTestResultController {

    Company company;
    TestStore testStore;
    List<Sample> tempList;

    public RecordTestResultController() {
        this.company = App.getInstance().getCompany();
        this.testStore = company.getTestStore();
        this.tempList = new ArrayList<>();
    }

    public void addTestResult(String parameterCode,String result, String metric, String code){
        Test test = testStore.getTest(code);
        test.addTestResult(parameterCode, result, metric);
    }

    public String getAvailableTest(){
        return testStore.getTestsList(State.RECORDED).toString();
    }
}
