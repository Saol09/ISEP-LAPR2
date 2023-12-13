package app.controller;

import app.domain.model.Company;
import app.domain.model.TypeOfTest;

public class RegisterTypeOfTestController {

    public Company company;
    private TypeOfTest tt;
    public RegisterTypeOfTestController() {
        this(App.getInstance().getCompany());
    }
    public RegisterTypeOfTestController(Company company) {
        this.company = company;
        this.tt = null;
    }

    public boolean registerTypeOfTest(String code, String description, String collectingMethods) {
        this.tt = this.company.registerTypeOfTest(code, description, collectingMethods);

        return this.company.validateTypeOfTest(tt);
    }

    public boolean saveTypeOfTest(TypeOfTest tt, String code) {
        tt.setParameterCategory(this.company.getCategory(code));
        return this.company.saveTypeOfTest(tt);
    }

    public String showCategories(){
        return company.getParameterCategoryList().toString();
    }
}
