package app.ui.console;

import app.controller.CreateDiagnosisReportController;
import app.controller.ShowResultsController;
import app.ui.console.utils.Utils;
import auth.UserSession;

public class ShowResultsUI implements Runnable {

    ShowResultsController ctrl = new ShowResultsController();
    CreateDiagnosisReportController ctrlRep = new CreateDiagnosisReportController();

    ShowResultsUI() {
    }

    @Override
    public void run() {

        System.out.println("\nList of tests performed by you: ");

        String a;
        String code;


        do {
            System.out.println(ctrl.getTestsByClient());

            try {
                code = Utils.readLineFromConsole("Type the test code you want to consult");


                System.out.println(ctrl.getTestResultsAndReport()); //TODO VERIFICAR SE ESTÁ CORRETO QUANDO O TIAGO ACABAR US12

            } catch (Exception e) {
                System.out.println("This test does not exist or it isn't ready to consult");
            }

            a = Utils.readLineFromConsole("Do you want to consult another test? (y/n)");

        } while (!a.equals("n"));
    }


}
