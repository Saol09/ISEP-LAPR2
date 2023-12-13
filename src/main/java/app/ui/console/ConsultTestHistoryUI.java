package app.ui.console;

import app.controller.ConsultTestHistoryController;
import app.ui.console.utils.Utils;

public class ConsultTestHistoryUI implements Runnable{

    ConsultTestHistoryController ctrl = new ConsultTestHistoryController();

    @Override
    public void run() {
        String a = new String();

        do{
            System.out.println(ctrl.getClientOrder());

            System.out.println("Do you want to see a client history?( insert end to end)");
            a = Utils.readLineFromConsole("Insert the TinNumber: ");

            if(!a.equals("0")){
                System.out.println(ctrl.getClientTests(a));
            }


        }while(!a.equals("end"));
    }
}
