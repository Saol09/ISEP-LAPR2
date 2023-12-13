package app.ui.console;

import app.controller.CreateDiagnosisReportController;
import app.domain.model.Test;
import app.domain.utils.DemoFile;
import app.ui.console.utils.Utils;

public class CreateDiagnosisReportUI implements Runnable {

    CreateDiagnosisReportController ctrl = new CreateDiagnosisReportController();

    public CreateDiagnosisReportUI() {
    }

    @Override
    public void run() {

        System.out.println("\nList of tests ready to get diagnosed: ");

        String code;
        String a;
        String report;


        do {
            System.out.println(ctrl.getReadyTests());

            try {
                code = Utils.readLineFromConsole("Type the test code you want to diagnose");



                System.out.println(ctrl.getReadyTest(code));

                report = Utils.readLineFromConsole("Write the diagnosis report for this test");


                try {
                    ctrl.saveReport(code, report);
                    System.out.println("Report added to the test.");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Exception ex) {
                System.out.println("This test does not exist or isn't ready for receiving a report");
            }


            a = Utils.readLineFromConsole("Do you want to write a report for another test? (y/n)");

        } while (!a.equals("n"));

    }

}
