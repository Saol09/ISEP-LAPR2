package app.ui.console;

import app.controller.RegisterTypeOfTestController;
import app.domain.model.TypeOfTest;
import app.ui.console.utils.Utils;

public class RegisterTypeOfTestUI implements Runnable {

    RegisterTypeOfTestController registerTypeOfTestController;
    public RegisterTypeOfTestUI(){
        registerTypeOfTestController= new RegisterTypeOfTestController();
    }
    public void run(){

        System.out.println("\nRegister type of test :");
        String code = Utils.readLineFromConsole("Type of Test code: ");
        String description = Utils.readLineFromConsole("Type of Test description: ");
        String collectingMethods = Utils.readLineFromConsole("Type of Test collectingMethods: ");
        System.out.println(registerTypeOfTestController.showCategories());
        String codeCat = Utils.readLineFromConsole("Type of Test code: ");
        if (Utils.confirm("Confirm the data? (S/N)")) {
            if (registerTypeOfTestController.registerTypeOfTest(code, description, collectingMethods)){
                registerTypeOfTestController.saveTypeOfTest(new TypeOfTest(code, description, collectingMethods),codeCat);
                System.out.println("Operation sucessfull.");
            } else {
                System.out.println("Some error ocorred.");
            }
        }
    }
}
