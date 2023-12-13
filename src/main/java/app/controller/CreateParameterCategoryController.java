package app.controller;

import app.domain.model.Company;
import app.domain.model.ParameterCategory;

public class CreateParameterCategoryController {
    public Company company;
    private ParameterCategory pc;
    public CreateParameterCategoryController() {
        this(App.getInstance().getCompany());
    }
    public CreateParameterCategoryController(Company company) {
        this.company = company;
        this.pc = null;
    }

    public boolean createParameterCategory(String code, String name) {
        this.pc = this.company.createParameterCategory(code, name);

        return this.company.validateParameterCategory(pc);
    }
    public boolean saveParameterCategory(ParameterCategory pc) {
        return this.company.saveParameterCategory(pc);
    }
    public boolean saveParameterCategory() {
        return this.company.saveParameterCategory(this.pc);
    }
}
