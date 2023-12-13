package app.controller;

import app.domain.model.Company;
import app.domain.model.State;
import app.domain.store.TestStore;
import app.domain.utils.DemoFile;

public class ValidateController {
    TestStore testStore;
    private Company company;

    public ValidateController(){
        this.company = App.getInstance().getCompany();
        this.testStore = company.getTestStore();

    }
    public String getDiagnosedTest(){

        return testStore.getDiagnosedTest();
    }


    public boolean validate(String code){
        if (testStore.validate(code)){
            try {
                testStore.changeTestState(code, State.VALIDATED);
                DemoFile.writeFile("Hi, your results are avaliable", "Emails\\"+testStore.getTest(code).getCode() + "_" + testStore.getTest(code).getClientTinNum());
            }catch (Exception e){
                System.out.println(e);
                return false;
            }
            return  true;
        }
        return  false;
    }

}
