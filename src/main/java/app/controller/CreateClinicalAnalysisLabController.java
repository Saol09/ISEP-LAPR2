package app.controller;

import app.domain.model.ClinicalAnalysisLab;
import app.domain.model.Company;
import app.domain.model.TypeOfTest;

import java.util.List;

public class CreateClinicalAnalysisLabController {
    private Company cmp;
    private ClinicalAnalysisLab cal;

    public CreateClinicalAnalysisLabController() {
        this(App.getInstance().getCompany());
    }
    public CreateClinicalAnalysisLabController(Company cmp) {
        this.cmp = cmp;
        this.cal = null;
    }
    public boolean createClinicalAnalysisLab(String idLaboratory, String name, String address, String phoneNumber, String tin, List<TypeOfTest> typeOfTest) {
        this.cal = this.cmp.createClinicalAnalysisLab(idLaboratory, name, address, phoneNumber, tin, typeOfTest);
        return this.cmp.validateClinicalAnalysisLab(cal);
    }

    public boolean saveClinicalAnalysisLab(ClinicalAnalysisLab cal) {
        return this.cmp.saveClinicalAnalysisLab(cal);
    }
    public boolean saveClinicalAnalysisLab() {
        return this.cmp.saveClinicalAnalysisLab(cal);
    }

    public List<TypeOfTest> getTypeTestList(){
        return cmp.getTypeOfTestList();
    }

    public TypeOfTest getTypeOfTestObj(String id){
        return cmp.getTypeOfTestObj(id);
    }

}
