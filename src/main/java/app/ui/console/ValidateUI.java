package app.ui.console;

import app.controller.ValidateController;
import app.ui.console.utils.Utils;

public class ValidateUI implements Runnable{

    ValidateController validateController = new ValidateController();
    public ValidateUI() {

    }

    public void run() {
        String value = new String();

        System.out.println("Insert the code of the test to be validated.");
        System.out.println("insert 0 to end");
        System.out.println(validateController.getDiagnosedTest());
        do {
            value = Utils.readLineFromConsole("Insert code: ");
            if(validateController.validate(value)){
                System.out.println("Test validated");
            }else{
                System.out.println("invalid code");
            }
        }while(!value.equals("0"));

        }
    }

