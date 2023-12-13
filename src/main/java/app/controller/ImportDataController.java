package app.controller;

import app.domain.model.Company;
import app.domain.model.DiagnosisReport;
import app.domain.store.ClientStore;
import app.domain.store.TestStore;

import java.io.FileNotFoundException;

public class ImportDataController {


    private Company company;
    private DiagnosisReport rep;
    private TestStore testStore;
    private ClientStore clientStore;
    private ImportDataService service;
    public ImportDataController() {
        this.company = App.getInstance().getCompany();
        this.testStore = company.getTestStore();
        this.clientStore = company.getClientStore();
        this.rep = null;
    }


    public String ImportData(String path){
        service = new ImportDataService();

        try {
            return service.ImportData(path);
        } catch (FileNotFoundException e) {
            return e.toString();
        }
    }



}
