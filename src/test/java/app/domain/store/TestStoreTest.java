package app.domain.store;

import app.domain.model.DiagnosisReport;
import app.domain.model.State;
import app.domain.model.TestParameter;
import app.domain.model.TypeOfTest;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TestStoreTest {
    TestStore testStore = new TestStore();
    @Before
    public void setUp(){
        TestParameter testParameter = new TestParameter();
        TypeOfTest typeOfTest = new TypeOfTest();

        testStore.addTestList("001","teste", State.DIAGNOSED,testParameter,typeOfTest,"1234567");
        testStore.addTestList("001","teste", State.READY,testParameter,typeOfTest,"1234567");
        testStore.addTestList("001","teste", State.NEW,testParameter,typeOfTest,"1234567");
    }

    @Test
    public void createReport() {
        assertEquals(new DiagnosisReport("teste").toString(),testStore.createReport("teste").toString());
    }

    @Test
    public void getTestsList() {
        assertNotNull(testStore.getTestsList(State.DIAGNOSED));
    }

    @Test
    public void getTestListBroke(){
        assertEquals(new ArrayList<>(),testStore.getTestsList(State.VALIDATED));
    }

    @Test
    public void getReadyTest() {
        assertNotNull(testStore.getTest("001"));
    }

    /*@Test
    public void saveReport() {
        assertTrue(testStore.saveReport(testStore.getTest("003"),new DiagnosisReport("teste") ));
    }*/

    @Test
    public void validate() {
        assertTrue(testStore.validate("001"));
    }

}