package app.ui.console;

import app.controller.CreateClinicalAnalysisLabController;
import app.domain.model.TypeOfTest;
import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class CreateClinicalAnalysisLabUI implements Runnable {

        CreateClinicalAnalysisLabController createClinicalAnalysisLabController;
        public CreateClinicalAnalysisLabUI(){
            createClinicalAnalysisLabController = new CreateClinicalAnalysisLabController();
        }
        public void run(){
            String op=null;
            int c =0;
            boolean flagIdLaboratory=true;

            System.out.println("\nCreate Clinical Analysis Lab:");
            String idLaboratory = Utils.readLineFromConsole("Clinical Analysis Laboratory ID(5 alphanumeric characters): ");
            String name = Utils.readLineFromConsole("Clinical Analysis Laboratory name(less that 20 characters): ");
            String address = Utils.readLineFromConsole("Clinical Analysis Laboratory address(less that 30 characters): ");
            String phoneNumber = Utils.readLineFromConsole("Clinical Analysis Laboratory Phone Number(11 digits): ");
            String tin = Utils.readLineFromConsole("Clinical Analysis Laboratory TIN(less that 10 digits): ");
            List<TypeOfTest> typeOfTest = new ArrayList<TypeOfTest>();
            System.out.println(createClinicalAnalysisLabController.getTypeTestList().toString());
            System.out.println("Select the type of test:");
            do {
                if(c!=0){
                    System.out.println("If all the intended Type of Tests are selected please type 0");
                }
                op = Utils.readLineFromConsole("Insert the type of test: ");
                typeOfTest.add(createClinicalAnalysisLabController.getTypeOfTestObj(op));
                c++;
            }while (!op.equals("0"));
            if (Utils.confirm("Confirm the data? (S/N)")) {
                if (createClinicalAnalysisLabController.createClinicalAnalysisLab(idLaboratory, name, address, phoneNumber, tin, typeOfTest)){
                    createClinicalAnalysisLabController.saveClinicalAnalysisLab();
                    System.out.println("Operation sucessfull.");
                } else {
                    System.out.println("Some error ocorred.");
                }
            }
        }
    }