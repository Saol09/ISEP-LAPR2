package app.controller;

import app.domain.model.*;
import app.domain.store.ClientStore;
import app.domain.store.TestStore;
import auth.UserSession;

public class ShowResultsController {
    private TestStore testStore;
    private Company company;
    private UserSession userSession;
    private Client client;
    private ClientStore clientStore;
    private String code;

    public ShowResultsController() {
        this.company = App.getInstance().getCompany();
        this.testStore = company.getTestStore();
        this.userSession = App.getInstance().getCurrentUserSession();
        this.clientStore = company.getClientStore();
        this.getClientByEmail();
    }

    /*
    public String getReadyTest(String code) {
        return  "Code ='" + code + '\'' +
                "Result =" + testStore.getTest(code).getTestParameterResult().getResult() +'\'' +
                "Metric =" + testStore.getTest(code).getTestParameterResult().getMetric() + '\'' +
                "Ref value =" + testStore.getTest(code).getTestParameterResult().getRefValue() + '\'';
    }

     */
    public void setTestCode(String code){
        this.code = code;
    }


    private void getClientByEmail() {
        this.client = clientStore.getClientByEmail(userSession.getUserId().getEmail());
    }

    public String getTestResultsAndReport() {
        String temp = new String();
        for (TestParameterResult e: testStore.getTest(this.code).getTestParameterResult()) {

            temp +=  "Code ='" + this.code + '\'' +
                    "Result =" + e.getResult() +'\'' +
                    "Metric =" + e.getMetric() + '\'' +
                    "Ref value =" + e.getRefValue() + '\'' + ' ';

        }
        temp +=testStore.getTest(this.code).getReport();
        return temp;
    }


    public String getTestsByClient() {
        String tempArray = new String();
        for (Test e : testStore.getTestsByClient(client.getTinNumber(), State.VALIDATED)) {
            tempArray += e.toStringReadyTests(); //TODO MUDAR STRING
        }
        return tempArray;
    }

}
