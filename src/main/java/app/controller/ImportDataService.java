package app.controller;

import app.domain.model.*;
import app.domain.store.ClientStore;
import app.domain.store.TestStore;
import auth.domain.model.Email;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ImportDataService {
    ClientStore cStore;
    TestStore tStore;
    Company company;
    private String testCode;
    public ImportDataService(){
        company = App.getInstance().getCompany();
        tStore = company.getTestStore();
        cStore = company.getClientStore();
    }

    public String ImportData(String path) throws FileNotFoundException {
        Scanner file = new Scanner(new File(path));
        String FileContent= "";
        int i=0;
        while(file.hasNextLine()){
            i++;
            System.out.println(i);
            String[] tempString;
            tempString = file.nextLine().strip().split(";");
                try{
                    Email email = new Email(tempString[9]);
                    cStore.addClient(new Client(tempString[8],tempString[3],tempString[4],tempString[5],tempString[6],"",tempString[7],tempString[9]));
                    if(tStore.getTest(tempString[0]) != null){
                        tempString[0]=(Double.parseDouble(tStore.getLastTest().getCode())+1)+"";
                    }
                    List<TestParameter> tempPara = new ArrayList<>();
                    Test test = new Test(tempString[0],tempString[1],company.getTypeOfTestObj(tempString[11]),tempString[5],tempPara);

                    test.setState(State.NEW,tempString[21] );
                    test.setState(State.READY,tempString[22] );
                    test.setState(State.DIAGNOSED,tempString[23] );
                    test.setState(State.VALIDATED,tempString[24] );
                    test.setIgGan(Double.parseDouble(tempString[20].replace(',','.')));
                    DiagnosisReport report = new DiagnosisReport(tempString[0] +"Imported");
                    report.setDiagnosedDate(tempString[23]);
                    test.setReport(report);
                    test.setClinicalAnalysisLab(company.getClinicalLab(tempString[2]));
                    tStore.addTest(test);
                    FileContent += tempString[0]+"\t"+tempString[1]+"\t"+tempString[2]+"\t"+tempString[3]+"\t"+tempString[4]+"\t"+tempString[5]+"\t"
                            +tempString[6]+"\t"+tempString[7]+"\t"+tempString[8]+"\t"+tempString[9]+"\t"+tempString[10]+"\t"+tempString[11]+"\t"+tempString[20]+"\t"+tempString[21]+"\t"+tempString[22]+"\t"+tempString[23]+"\t"+tempString[24]+"\n";
                }catch (IllegalArgumentException |ArrayIndexOutOfBoundsException e){
                    FileContent += "--------------------Erro---------------------\n";
                }



/*
                tempString[0] testcode
                tempString[1] nhsCode
                tempString[2] Lab_ID
                tempString[3] CitizenCard_Number
                tempString[4] NHS_Number
                tempString[5] TIN
                tempString[6] BirthDay
                tempString[7] PhoneNumber
                tempString[8] Name
                tempString[9] E-mail
                tempString[10] Address
                tempString[11] TestType
                tempString[12] Category
                tempString[13] para
                tempString[14] para
                tempString[15] para
                tempString[16] para
                tempString[17] Category?
                tempString[18] para
                tempString[19] Category
                tempString[20] igGan
                tempString[21] Test_Reg_DateHour
                tempString[22] Test_Chemical_DateHour
                tempString[23] Test_Doctor_DateHour
                tempString[24] Test_Validation_DateHour
                */

            }




        return FileContent;
    }


}
