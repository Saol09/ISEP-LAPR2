package app.domain.model;

import app.controller.App;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CompanyTest {
    Company company= App.getInstance().getCompany() ;
    ParameterCategory parameterCategory = new ParameterCategory("12345","test");
    Parameter parameter = new Parameter("12345","test","teste desc",parameterCategory);
    List<Parameter> parameterList = new ArrayList<>();
    List<ParameterCategory> parameterCategoryList = new ArrayList<>();
    List<TypeOfTest> tp = new ArrayList<>();
    TypeOfTest tp1 = new TypeOfTest("1","teste1","teste2");
    ClinicalAnalysisLab cal1 = new ClinicalAnalysisLab("12345","testename","testeaddress","12345678901","12345",tp);

    @Test
    public void getParameterCategoryList() {
        parameterList.add(parameter);
        assertEquals(parameterList.toString(),"[Parameter{code='12345', name='test', desc='teste desc', category code='12345', category name='test'}]");
    }

    @Test
    public void createAndAddUser() {

    }

    @Test
    public void createParameter() {
        assertEquals(company.createParameter("12345","test","teste desc",parameterCategory).toString(),parameter.toString());
    }
    /*
    @Test
    public void getCategory() {
        company.saveParameterCategory(parameterCategory);
        assertEquals(company.getCategory(parameterCategory.getCode()),parameterCategory);
    }
    */
    @Test
    public void createParameterCategory() {
        assertEquals(company.createParameterCategory("12345","test"),parameterCategory);
    }

    @Test
    public void getDesignation() {
        assertEquals(company.getDesignation(),"Many Labs");
    }

    @Test
    public void getAuthFacade() {
        assertNotNull(company.getAuthFacade());
    }

    @Test
    public void validateParameterCategory() {
        parameterCategory.setCode("code2");
        assertTrue(company.validateParameterCategory(parameterCategory));
    }

    @Test
    public void saveParameterCategory() {
        parameterCategory.setCode("12434");
        assertTrue(company.saveParameterCategory(parameterCategory));
    }

    @Test
    public void validateParameter() {
        assertTrue(company.validateParameter(parameter));
    }

    @Test
    public void saveParameter() {
        assertTrue(company.saveParameter(parameter));
    }

    @Test
    public void registerTypeOfTest() {
        assertEquals(company.registerTypeOfTest("1","teste1","teste2").toString(), tp1.toString());
    }

    @Test
    public void getEmployeeStore() {
        assertEquals(company.getEmployeeStore(),this.company.getEmployeeStore());
    }

    @Test
    public void validateTypeOfTest() {
        assertTrue(company.validateTypeOfTest(tp1));
    }

    @Test
    public void saveTypeOfTest() {
        assertTrue(company.saveTypeOfTest(tp1));
    }

    @Test
    public void createClinicalAnalysisLab() {
        assertEquals(company.createClinicalAnalysisLab("12345","testename","testeaddress","12345678901","12345",tp).toString(),cal1.toString());
    }

    @Test
    public void validateClinicalAnalysisLab() {
        assertTrue(company.validateClinicalAnalysisLab(cal1));
    }

    @Test
    public void saveClinicalAnalysisLab() {
        company.createClinicalAnalysisLab("12345","testename","testeaddress","12345678901","12345",tp);
        assertTrue(company.saveClinicalAnalysisLab(cal1));
    }

    @Test
    public void getTypeOfTestList() {
        tp.add(tp1);
        assertNotNull(tp);
    }

    @Test
    public void getTypeOfTestObj() {
        company.saveTypeOfTest(tp1);
        assertEquals(company.getTypeOfTestObj("1").toString(),tp1.toString());
    }
}