package app.ui.console;

import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class MedicalLabTechnicianUI implements Runnable{
    @Override
    public void run() {
        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("Create a sample to a Test", new CreateSampleTestUI()));
        options.add(new MenuItem("Leave ", new ShowTextUI("You chose to leave.")));

        int option = 0;
        do{
            option = Utils.showAndSelectIndex(options, "\n\nMedical Lab Technician Menu:");

            if((option >= 0) && (option < options.size())){
                options.get(option).run();
            }
        }
        while (option != -1);
    }
}
