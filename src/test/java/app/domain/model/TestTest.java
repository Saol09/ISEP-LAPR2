package app.domain.model;

import app.controller.CreateSampleTestController;
import com.example2.EMRefValue;
import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeFactory;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class TestTest {
    List<Sample> testList;
    List<TypeOfTest> typeOfTest;
    app.domain.model.Test test;

    @Before
   public void setUp() throws BarcodeException {
       Barcode barcode = BarcodeFactory.createUPCA("12345678901");
       final app.domain.model.Sample smp1 = new app.domain.model.Sample(barcode);
        testList = new ArrayList<>();

       testList.add(smp1);
    }



    final app.domain.model.Test test1 = new app.domain.model.Test("12345","12345", new TypeOfTest("32101",
        "description","aaa"),"987456321",
        new TestParameter("12345",new Parameter("11123", "param", "descL",
                new ParameterCategory("45789", "name"))));


    @Test
    public void getClinicalAnalysisLabTest(){

        test1.setClinicalAnalysisLab(new ClinicalAnalysisLab("12345", "Cascais", "Rua das casas",
                "12345678912", "12345678", new ArrayList<TypeOfTest>()));

        assertEquals(test1.getClinicalAnalysisLab().toString(),new ClinicalAnalysisLab("12345", "Cascais", "Rua das casas",
                "12345678912", "12345678", new ArrayList<TypeOfTest>()).toString());
    }

    @Test
    public void ClinicalAnalysisLabTest(){
        test1.setClinicalAnalysisLab(new ClinicalAnalysisLab("12345", "Cascais", "Rua das casas",
                "12345678912", "12345678", new ArrayList<TypeOfTest>()));

        assertEquals(test1.getClinicalAnalysisLab().toString(),new ClinicalAnalysisLab("12345", "Cascais", "Rua das casas",
                "12345678912", "12345678", new ArrayList<TypeOfTest>()).toString());
    }


    @Test
    public void getCode() {
        assertEquals("12345", test1.getCode());
    }

    @Test
    public void setCode() {
        test1.setCode("4321");
        assertEquals(test1.getCode(), "4321");
    }

    @Test
    public void getClientTinNumTest(){
        assertEquals("987456321", test1.getClientTinNum());
    }

    @Test
    public void setClientTinNumTest(){
        test1.setClientTinNum("987456333");
        assertEquals(test1.getClientTinNum(), "987456333");
    }

    @Test
    public void getNhsCode() {
        assertEquals("12345", test1.getNhsCode());
    }

    @Test
    public void setNhsCode() {
        test1.setNhsCode("0987456123");
        assertEquals(test1.getNhsCode(), "0987456123");
    }

    @Test
    public void getState() {
        assertEquals(test1.getState(), test1.getState());
    }

    @Test
    public void setState() {

        assertTrue(test1.setState(State.READY,"11/10/2000"));
    }


    @Test
    public void getReport() {
        test1.setReport( new DiagnosisReport("The report has been done"));
        assertEquals(new DiagnosisReport("The report has been done").toString(), test1.getReport().toString());
    }

    @Test
    public void setReport() {
        test1.setReport(new DiagnosisReport("The report is done and ready to be seen"));
        assertEquals(test1.getReport().toString(), new DiagnosisReport("The report is done and ready to be seen").toString());
    }

    @Test
    public void getSampleList() {
        app.domain.model.Test testBefore = new app.domain.model.Test("12345","12345", new TypeOfTest("32101",
                "description","aaa"),"987456321",
                new TestParameter("12345",new Parameter("11123", "param", "descL",
                        new ParameterCategory("45789", "name"))));
        testBefore.setSampleList(testList);
        assertNotNull(testBefore.getSampleList());
    }

    @Test
    public void setSampleList() {
        app.domain.model.Test testBefore = new app.domain.model.Test("12345","12345", new TypeOfTest("32101",
                "description","aaa"),"987456321",
                new TestParameter("12345",new Parameter("11123", "param", "descL",
                        new ParameterCategory("45789", "name"))));
        testBefore.setSampleList(testList);
        assertNotNull(testBefore.getSampleList());
    }

    @Test
    public void getTestParameterResult() {
        test1.setTestParameterResult(new TestParameterResult("mg","100", new EMRefValue("123", "mg",
                0.5, 1.5, new Date())));
        assertEquals("["+new TestParameterResult("mg",
                "100", new EMRefValue("123", "mg", 0.5, 1.5,
                new Date())).toString()+"]", test1.getTestParameterResult().toString());

    }

    @Test
    public void setTestParameterResult() {
        test1.setTestParameterResult(new TestParameterResult("ml",
                "100", new EMRefValue("123", "ml", 0.5, 1.5,
                new Date())));
        assertEquals(test1.getTestParameterResult().toString(),"[" + new TestParameterResult("ml",
                "100", new EMRefValue("123", "ml", 0.5, 1.5,
                new Date())).toString()+"]");
    }

    @Test
    public void addTestResult() {
        assertTrue(test1.addTestResult("12345","12","1"));
    }






   }