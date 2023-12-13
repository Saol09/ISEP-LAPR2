package app.domain.store;

import app.domain.model.*;
import app.domain.utils.SaveDate;
import org.apache.commons.lang3.ObjectUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TestStore implements Serializable {
    private ArrayList<Test> testList;

    public TestStore() {
        testList = new ArrayList<>();
    }

    public void addTestList(String code,String nhsCode, State state, TestParameter testParameter, TypeOfTest typeOfTest, String tinNumber){
            Test tempTest = new Test(code, nhsCode,typeOfTest,tinNumber ,testParameter);
            tempTest.setState(state, SaveDate.dataCreation());
            testList.add(tempTest);

    }

    public void addTest(Test test){
        testList.add(test);

    }

    //UC-14



    public DiagnosisReport createReport(String report) {
        return new DiagnosisReport(report);
    }

    public ArrayList<Test> getTestsList(State state) {
        ArrayList<Test> tempList = new ArrayList<>();
        for (int i = 0; testList.size() > i; i++) {
            try{
                testList.get(i).getData(state).equals(null);
                tempList.add(testList.get(i));
            }catch(NullPointerException e){

            }
        }
        return tempList;
    }

    public Test getLastTest(){
        return testList.get(testList.size()-1);
    }

    public Test getTest(String code) {
        for (int i = 0; testList.size() > i; i++) {
            if (testList.get(i).getCode().equals(code)) {
                return testList.get(i);
            }
        }
        return null;
    }


    private void addReport(Test test, DiagnosisReport report) {
        this.testList.remove(test);
        test.setReport(report);
        test.setState(State.DIAGNOSED,report.getDiagnosedDate());
        this.testList.add(test);
    }

    private boolean validateReport(Test test) {
        if (test == null)
            return false;
        for (int i = 0; this.testList.size() > i; i++) {
            if (testList.get(i).getCode().equals(test.getCode())) {

                return false;
            }
        }
        return true;
    }


    public boolean saveReport(Test test, DiagnosisReport rep) {

        if (!validateReport(test))
            return false;
        addReport(test, rep);

        return true;
    }

    //UC-14 END
    //UC-15 begin
    public String getDiagnosedTest() {
        String tempString = new String();
        for (int i = 0; testList.size() > i; i++) {
            try{
                testList.get(i).getData(State.DIAGNOSED).equals(null);
                tempString += testList.get(i).shortString();
            }catch(NullPointerException e){

            }
        }
        return tempString;
    }

    public State getStateTest(Test test){
        State temp= null;
        for (State e: test.getState().keySet()) {
            temp= e;
        }
        return temp ;
    }

    public boolean validate(String code) {
        boolean flag = false;
        for (Test e : testList) {
            if (e.getCode().equals(code)) {
                try{
                    e.getData(State.DIAGNOSED).equals(null);
                    flag = true;
                }catch(NullPointerException ex){

                }

            }
        }
        return flag;
    }

    public void changeTestState(String code, State state){
        for (int i = 0; testList.size() > i; i++) {
            if (testList.get(i).getCode().equals(code)) {
                testList.get(i).setState(state,SaveDate.dataCreation());

            }
        }
    }

    //UC-5 begin

    public List<Test> getNewTests() {
        List<Test> tempList = new ArrayList<>();
        for (int i = 0; testList.size() > i; i++) {
            if(testList.get(i).getState().size()==1){
                tempList.add(testList.get(i));
            }

        }
        return tempList;
    }


    //UC-5 end

    //UC-01 begin


    public ArrayList<Test> getTestsByClient(String clientTinNum, State state){
        ArrayList<Test> tempList = new ArrayList<>();
        for (int i = 0; testList.size() > i; i++){
            if (testList.get(i).getClientTinNum().equals(clientTinNum)){
                try{
                    testList.get(i).getData(state).equals(null);
                    tempList.add(testList.get(i));
                }catch (NullPointerException ex){

                }
            }
        }
        return tempList;
    }

    //UC-01 end

    //UC-13

    public List<Test> getTestsByClient(String clientTinNum){
        List<Test> tempList = new ArrayList<>();
        for (int i = 0; testList.size() > i; i++){
            if (testList.get(i).getClientTinNum().equals(clientTinNum)){
                tempList.add(testList.get(i));
            }
        }
        return tempList;
    }



    public List<Test> getTestbyInterval(String data1, String data2) {

        List<Test> temp = new ArrayList<>();
        int diaDay1 =Integer.parseInt(data1.substring(0,2));
        int MesDay1 =Integer.parseInt(data1.substring(3,5));
        int diaDay2 =Integer.parseInt(data2.substring(0,2));
        int MesDay2 =Integer.parseInt(data2.substring(3,5));
            for (Test e:getTestsList(State.VALIDATED)) {
                int diaTest =Integer.parseInt(e.getData(State.VALIDATED).substring(0,2));
                int MesTest =Integer.parseInt(e.getData(State.VALIDATED).substring(3,5));
                System.out.println(e.getData(State.VALIDATED));
                System.out.println("dia test: "+diaTest);
                System.out.println("mes test: "+MesTest);

                if ((diaTest<=diaDay2 && MesTest<=MesDay2) &&(diaTest>=diaDay1 && MesTest>=MesDay1)){
                        temp.add(e);
                }
            }

        return temp;
    }

    //UC-13 end

}
