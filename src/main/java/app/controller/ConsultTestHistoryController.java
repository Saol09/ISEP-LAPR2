package app.controller;

import app.domain.model.Client;
import app.domain.model.Company;
import app.domain.model.Test;
import app.domain.store.ClientStore;
import app.domain.store.TestStore;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConsultTestHistoryController {

    ClientStore clientStore;
    TestStore testStore;
    private Company company;

    public ConsultTestHistoryController(){
        this.company = App.getInstance().getCompany();
        this.clientStore = company.getClientStore();
        this.testStore = company.getTestStore();
    }

    public String getClientOrder(){
        try {
            String tempS = new String();
            Properties prop = new Properties();
            InputStream in = new FileInputStream("config.properties");
            prop.load(in);
            in.close();
            for (Client c : clientStore.getClientOrder(prop.getProperty("TipoOrdem"))) {
                tempS += c.toShortString() +"\n";
            }
            return tempS;

        }catch ( IOException e){
            return null;
        }
    }

    public String getClientTests(String tin){
        String tempArray = new String();
        for (Test e : testStore.getTestsByClient(tin)) {
            tempArray += e.testString() + "\n";
        }
        return tempArray;
    }

}
