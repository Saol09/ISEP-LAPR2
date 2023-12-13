package app.ui.console;


import app.controller.CreateParameterController;
import app.domain.model.Parameter;
import app.ui.console.utils.Utils;

public class CreateParameterUI implements Runnable {
    CreateParameterController createParameterController;
    public CreateParameterUI(){
        createParameterController= new CreateParameterController();
    }
    public void run(){

        System.out.println("\nCreate parameter :");
        String code = Utils.readLineFromConsole("Parameter code: ");
        String name = Utils.readLineFromConsole("Parameter name: ");
        String desc = Utils.readLineFromConsole("Parameter description: ");
        System.out.println(createParameterController.showCategories());
        String codeCat = Utils.readLineFromConsole("Parameter category code: ");
        if (Utils.confirm("Confirm the data? (S/N)")) {
            if (createParameterController.createParameter(code,name,desc,codeCat)){
                createParameterController.saveParameter();
                System.out.println("Operation sucessfull.");
            } else {
                System.out.println("Some error ocorred.");
            }
        }
    }
}
