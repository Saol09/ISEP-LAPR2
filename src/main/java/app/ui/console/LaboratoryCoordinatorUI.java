package app.ui.console;

import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class LaboratoryCoordinatorUI implements Runnable{

    public LaboratoryCoordinatorUI(){}

    public void run(){
        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("Validate a Test", new ValidateUI()));

        int option = 0;
        do{
            option = Utils.showAndSelectIndex(options, "\n\nLaboratory Coordinator Menu:");

            if((option >= 0) && (option < options.size())){
                options.get(option).run();
            }
        }
        while (option != -1);

    }
}
