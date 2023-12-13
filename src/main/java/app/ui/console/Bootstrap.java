package app.ui.console;

import app.controller.App;
import app.domain.model.*;
import app.domain.store.ClientStore;
import app.domain.store.TestStore;
import app.domain.utils.SaveDate;
import com.example2.EMRefValue;
import com.example2.ExternalModule2API;

import java.util.ArrayList;
import java.util.Date;

public class Bootstrap {
    private TestStore testStore;
    private Company company;
    private ClientStore clientStore;
    private ExternalModule2API api = new ExternalModule2API();




    public Bootstrap() {
        this.company = App.getInstance().getCompany();
        this.testStore = company.getTestStore();
        this.clientStore = company.getClientStore();
        bootstrapLabs();
        bootstrapTests();
    }

    public void bootstrapLabs(){
        ClinicalAnalysisLab clinicalAnalysisLab = new ClinicalAnalysisLab("001DO", "Lab1", "rua do lab1", "12345678912", "1234567890",company.getTypeOfTestList());
        company.saveClinicalAnalysisLab(clinicalAnalysisLab);
        clinicalAnalysisLab = new ClinicalAnalysisLab("001LN", "Lab2", "rua do lab2", "12345678913", "1234567892",company.getTypeOfTestList());
        company.saveClinicalAnalysisLab(clinicalAnalysisLab);
        clinicalAnalysisLab = new ClinicalAnalysisLab("001LR", "Lab3", "rua do lab3", "12345678913", "1234567892",company.getTypeOfTestList());
        company.saveClinicalAnalysisLab(clinicalAnalysisLab);
        clinicalAnalysisLab = new ClinicalAnalysisLab("001MA", "Lab4", "rua do lab4", "12345678913", "1234567892",company.getTypeOfTestList());
        company.saveClinicalAnalysisLab(clinicalAnalysisLab);
        clinicalAnalysisLab = new ClinicalAnalysisLab("001SO", "Lab5", "rua do lab5", "12345678913", "1234567892",company.getTypeOfTestList());
        company.saveClinicalAnalysisLab(clinicalAnalysisLab);
        clinicalAnalysisLab = new ClinicalAnalysisLab("001WA", "Lab6", "rua do lab6", "12345678913", "1234567892",company.getTypeOfTestList());
        company.saveClinicalAnalysisLab(clinicalAnalysisLab);
    }

    public void bootstrapParameterCategory(){
        ParameterCategory parameterCategory = new ParameterCategory("12345","Covid");
        company.saveParameterCategory(parameterCategory);
    }

    public void bootstrapParameters(){
        Parameter parameter = new Parameter("123","HB000","parametro",company.getCategory("12345"));
        company.saveParameter(parameter);
        parameter = new Parameter("125","WBC000","parametro",company.getCategory("12345"));
        company.saveParameter(parameter);
    }

    public void bootstrapTests(){

        Client c1 = new Client("Vaulo", "12365487","5465421","987","12-12-1985","Male","32165498703","paulo@isep.ipp.pt");
        clientStore.addClient(c1);
        Test test = new Test("123","222",new TypeOfTest("123","aaa","tubo"),"987",new TestParameter("333",null));
        Test test10 = new Test("122","222",new TypeOfTest("123","aaa","tubo"),"987",new TestParameter("333",null));
        test.setClinicalAnalysisLab(company.getClinicalLab("123ab"));
        test10.setClinicalAnalysisLab(company.getClinicalLab("123ab"));
        testStore.addTest(test);
        testStore.addTest(test10);

        Client sergio = new Client("Sérgio Lopes", "12365489","5465454","988","12-12-1985","Male","32165498701","client001@lei.sem2.pt");
        clientStore.addClient(sergio);

        Test testSergio = new Test("125", "5465454", new TypeOfTest("125", "bbb", "tubo"),"988", new TestParameter("334", null));
        testSergio.setReport(new DiagnosisReport("The results are just fine."));
        testSergio.setState(State.VALIDATED, SaveDate.dataCreation());
        testSergio.setTestParameterResult(new TestParameterResult("dm", "10.15",new EMRefValue("1005", "dm", 9.5, 12.5,new Date())));
        testStore.addTest(testSergio);

        Test test2Sergio = new Test("250", "5465454", new TypeOfTest("250", "ccc", "s/tubo"),"988", new TestParameter("250", null));
        test2Sergio.setReport(new DiagnosisReport("The results are not very well."));
        test2Sergio.setState(State.VALIDATED, SaveDate.dataCreation());
        test2Sergio.setTestParameterResult(new TestParameterResult("x", "6",new EMRefValue("1005", "dm", 5.0, 7.5,new Date())));
        testStore.addTest(test2Sergio);



        Client tiago = new Client("Tiago Silva", "987654321","123456","744","20-12-2000","Male","98745612312","client002@lei.sem2.pt");
        clientStore.addClient(tiago);

        Test testTiago = new Test("102", "5465455", new TypeOfTest("102", "aaa", "tubo/s"),"744", new TestParameter("102", null));
        testTiago.setReport(new DiagnosisReport("The results are bad but you will recover."));
        testTiago.setState(State.VALIDATED, SaveDate.dataCreation());
        testTiago.setTestParameterResult(new TestParameterResult("cm", "10.50",new EMRefValue("1000", "cm", 9.0, 10.5,new Date())));
        testStore.addTest(testTiago);



        Client paulo = new Client("Paulo Couto", "456789123","987412","911","25-05-2000","Male","45612378974","client003@lei.sem2.pt");
        clientStore.addClient(paulo);

        Test testPaulo = new Test("301", "451242", new TypeOfTest("301", "aaa", "tubo/s"),"911", new TestParameter("301", null));
        testPaulo.setReport(new DiagnosisReport("The results are incredible."));
        testPaulo.setState(State.VALIDATED, SaveDate.dataCreation());
        testPaulo.setTestParameterResult(new TestParameterResult("xm", "20.74",new EMRefValue("745", "xm", 15.8, 21.0,new Date())));
        testStore.addTest(testPaulo);


        Test test2 = new Test("456", "321", new TypeOfTest("456", "bbb","tubo"), "789", new TestParameter("111", null));
        test2.setState(State.READY, SaveDate.dataCreation());
        test2.addTestResult("12345","2","mg");
        test.setClinicalAnalysisLab(company.getClinicalLab("abc12"));
        testStore.addTest(test2);

        Test test4 = new Test("321", "321", new TypeOfTest("456", "bbb","tubo"), "789", new TestParameter("111", null));
        test4.setReport(new DiagnosisReport("teste"));
        test4.addTestResult("12345","2","mg");
        test4.setState(State.DIAGNOSED, SaveDate.dataCreation());
        testStore.addTest(test4);

        Test test7 = new Test("119","222",new TypeOfTest("123","aaa","tubo"),"321",new TestParameter("333",null));
        test7.setState(State.NEW, SaveDate.dataCreation());
        testStore.addTest(test7);

        Test test3 = new Test("111","222",new TypeOfTest("123","aaa","tubo"),"321",new TestParameter("333",null));
        test3.setState(State.READY, SaveDate.dataCreation());
        testStore.addTest(test3);
    }





}
