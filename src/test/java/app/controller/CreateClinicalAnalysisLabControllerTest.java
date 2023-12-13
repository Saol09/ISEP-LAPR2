package app.controller;

import app.domain.model.ClinicalAnalysisLab;
import app.domain.model.Company;
import app.domain.model.TypeOfTest;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CreateClinicalAnalysisLabControllerTest {
    Company cmp =App.getInstance().getCompany();
    TypeOfTest tp1 = new TypeOfTest("1","teste1","teste2");
    List<TypeOfTest> tp = new ArrayList<>();
    CreateClinicalAnalysisLabController cal = new CreateClinicalAnalysisLabController();
    ClinicalAnalysisLab cal1 = new ClinicalAnalysisLab("12345","testename","testeaddress","12345678901","12345",tp);


    @Test
    public void createClinicalAnalysisLab() {
        assertTrue(cal.createClinicalAnalysisLab("12345","testename","testeaddress","12345678901","12345",tp));
    }

    @Test
    public void saveClinicalAnalysisLab() {
        assertTrue(cal.saveClinicalAnalysisLab(cal1));
    }

    @Test
    public void testSaveClinicalAnalysisLab() {
        cal.createClinicalAnalysisLab("12345","testename","testeaddress","12345678901","12345",tp);
        assertTrue(cal.saveClinicalAnalysisLab());
    }


    @Test
    public void getTypeTestList() {
        tp.add(tp1);
        assertNotNull(tp);
    }

    /*@Test
    public void getTypeOfTestObj() {
        tp.add(tp1);
        cmp.saveTypeOfTest(tp1);
        assertEquals(cmp.getTypeOfTestObj("1"),tp1);
    }*/
}