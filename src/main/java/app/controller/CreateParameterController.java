package app.controller;

import app.domain.model.Company;
import app.domain.model.Parameter;
import app.domain.model.ParameterCategory;

import java.util.List;

public class CreateParameterController {
    private Company company;
    private Parameter parameter;

    public CreateParameterController() {
        this(App.getInstance().getCompany());
    }
    public CreateParameterController(Company company) {
        this.company = company;
        this.parameter = null;
    }


    public String showCategories(){
        return company.getParameterCategoryList().toString();
    }
    public boolean createParameter(String _code, String _name, String _desce, String codeCategory) {
        this.parameter = this.company.createParameter(_code, _name,_desce,this.company.getCategory(codeCategory));
        return this.company.validateParameter(parameter);
    }
    public boolean saveParameter(Parameter parameter) {
        return this.company.saveParameter(parameter);
    }
    public boolean saveParameter() {
        return this.company.saveParameter(this.parameter);
    }
}
