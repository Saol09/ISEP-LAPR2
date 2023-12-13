package app.domain.model;

import app.domain.store.ClientStore;
import app.domain.store.EmployeeStore;
import app.domain.model.employee.OrganizationRole;
import app.domain.shared.Constants;
import app.domain.store.TestStore;
import auth.AuthFacade;
import com.example2.EMRefValue;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class Company {

    private String designation;
    private AuthFacade authFacade;
    private List<ParameterCategory> parameterCategoryList = new ArrayList<>();
    public List<Parameter> parameterList = new ArrayList<>();
    public List<TypeOfTest> typeOfTestList = new ArrayList<>();
    private List<ClinicalAnalysisLab> clinicalAnalysisLabList = new ArrayList<>();
    private EmployeeStore employeeStore = new EmployeeStore();
    private List<OrganizationRole> organizationRoleList = new ArrayList<>();
    private TestStore testStore = new TestStore();
    private ClientStore clientStore = new ClientStore();
    public Company(String designation) {
        if (StringUtils.isBlank(designation))
            throw new IllegalArgumentException("Designation cannot be blank.");

        this.designation = designation;
        this.authFacade = new AuthFacade();

    }

    public ClientStore getClientStore(){
        return clientStore;
    }

    public List<ParameterCategory> getParameterCategoryList() {
        return parameterCategoryList;
    }

    public Boolean CreateAndAddUser(String name, String email, String pwd) {
        return this.authFacade.addUser(name, email, pwd);
    }

    public Parameter createParameter(String _code, String _name, String _desc, ParameterCategory parameterCategory) {
        Parameter parameter = new Parameter(_code, _name, _desc, parameterCategory);

        return parameter;
    }

    public Parameter getParameter(String code){
        for (Parameter e:parameterList ) {
            if (e.getCode().equals(code)){
                return e;
            }
        }

        return null;
    }

    public ParameterCategory getCategory(String code) {
        for (ParameterCategory parameterCategory : parameterCategoryList) {

            if (parameterCategory.getCode().equals(code)) {
                return parameterCategory;
            }
        }
        return null;
    }

    public ClinicalAnalysisLab getClinicalLab(String code){
        for (ClinicalAnalysisLab e:clinicalAnalysisLabList) {
            if (e.getIdLaboratory().equals(code)){
                return e;
            }
        }
        return null;
    }

    public ParameterCategory createParameterCategory(String code, String name) {
        ParameterCategory pCategory = new ParameterCategory(code, name);

        return pCategory;
    }


    public String getDesignation() {
        return designation;
    }

    public AuthFacade getAuthFacade() {
        return authFacade;
    }

    public boolean validateParameterCategory(ParameterCategory parameterCategory) {
        if (parameterCategory == null) {
            return false;
        }

        return !this.parameterCategoryList.contains(parameterCategory);
    }

    public boolean saveParameterCategory(ParameterCategory parameterCategory) {
        if (!validateParameterCategory(parameterCategory)) {
            return false;
        }
        return this.parameterCategoryList.add(parameterCategory);
    }

    public boolean validateParameter(Parameter parameter) {
        if (parameter == null) {
            return false;
        }
        return !this.parameterList.contains(parameter);
    }

    public boolean saveParameter(Parameter parameter) {
        if (!validateParameter(parameter)) {
            return false;
        }

        return this.parameterList.add(parameter);
    }

    public TypeOfTest registerTypeOfTest(String code, String description, String collectingMethods) {
        TypeOfTest typeOfTest = new TypeOfTest(code, description, collectingMethods);

        return typeOfTest;
    }


    public EmployeeStore getEmployeeStore() {
        return employeeStore;
    }

    public boolean validateTypeOfTest(TypeOfTest typeOfTest) {
        if (typeOfTest == null) {
            return false;
        }
        return !this.typeOfTestList.contains(typeOfTest);
    }

    public boolean saveTypeOfTest(TypeOfTest typeOfTest) {
        if (!validateTypeOfTest(typeOfTest)) {
            return false;
        }
        return this.typeOfTestList.add(typeOfTest);
    }

    //Clinical Analysis Lab

    public ClinicalAnalysisLab createClinicalAnalysisLab(String idLaboratory, String name, String address, String phoneNumber, String tin, List<TypeOfTest> typeOfTest) {
        ClinicalAnalysisLab ncal = new ClinicalAnalysisLab(idLaboratory, name, address, phoneNumber, tin, typeOfTest);

        return ncal;
    }


    public boolean validateClinicalAnalysisLab(ClinicalAnalysisLab clinicalAnalysisLab) {
        if (clinicalAnalysisLab == null) {
            return false;
        }

        return !this.clinicalAnalysisLabList.contains(clinicalAnalysisLab);
    }


    public boolean saveClinicalAnalysisLab(ClinicalAnalysisLab clinicalAnalysisLab){
        if (!validateClinicalAnalysisLab(clinicalAnalysisLab)){
            return false;
        }
        return this.clinicalAnalysisLabList.add(clinicalAnalysisLab);
    }

    public List<TypeOfTest> getTypeOfTestList() {
        return typeOfTestList;
    }

    public TypeOfTest getTypeOfTestObj(String id){
        for(TypeOfTest tp: this.typeOfTestList){
            if (tp.getCode().equals(id)) return tp;
        }
        return null;
    }



    //Clinical Analysis Lab end

    //Organization Role
    public void bootstrapRoles(){
        organizationRoleList.add(0, new OrganizationRole(Constants.ROLE_RECEPTIONIST));
        organizationRoleList.add(1, new OrganizationRole(Constants.ROLE_LAB_COORDINATOR));
        organizationRoleList.add(2, new OrganizationRole(Constants.ROLE_CLINICAL_CHEMISTRY_TEC));
        organizationRoleList.add(3,new OrganizationRole(Constants.ROLE_MEDICAL_LAB_TECHNICIAN));
        organizationRoleList.add(4,new OrganizationRole(Constants.ROLE_SPECIALIST_DOCTOR));
    }

    public OrganizationRole getRole(int index){
        return this.organizationRoleList.get(index);
    }

    public List<OrganizationRole> getOrganizationRoleList() {
        return organizationRoleList;
    }

    //Organization Role end

    //Test

    public TestStore getTestStore(){
        return testStore;
    }

    //Test END
}
