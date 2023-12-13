package app.ui.console;

import app.controller.CreateParameterCategoryController;
import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class CreateParameterCategoryUI implements Runnable {
    CreateParameterCategoryController createParameterCategoryController;
    public CreateParameterCategoryUI(){
        createParameterCategoryController= new CreateParameterCategoryController();
    }
    public void run(){

            System.out.println("\nCreate parameter category:");
            String code = Utils.readLineFromConsole("Category code: ");
            String name = Utils.readLineFromConsole("Category name: ");
                if (Utils.confirm("Confirm the data? (S/N)")) {
                    if (createParameterCategoryController.createParameterCategory(code,name)){
                        createParameterCategoryController.saveParameterCategory();
                        System.out.println("Operation sucessfull.");
                    } else {
                        System.out.println("Some error ocorred.");
                    }
                }
    }
}

