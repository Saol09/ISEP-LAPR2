package app.ui.console;

import app.controller.RecordTestResultController;
import app.ui.console.utils.Utils;
//import sun.security.krb5.internal.PAData;

public class RecordTestResultUI implements Runnable{

    RecordTestResultController ctrl = new RecordTestResultController();
    @Override
   public void run() {
        String a;
        System.out.println("\nInsert test results: ");
        do {
            System.out.println(ctrl.getAvailableTest());
            String code = Utils.readLineFromConsole("Insert code test ");
            a = Utils.readLineFromConsole("Do you want to proceed (Y/N)? ");
        }while(!a.equals("n"));
    }

}
