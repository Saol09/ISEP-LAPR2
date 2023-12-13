package app.ui.console;

import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */

public class AdminUI implements Runnable{
    public AdminUI()
    {
    }

    public void run()
    {
        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("Create parameter category ", new CreateParameterCategoryUI()));
        options.add(new MenuItem("Create parameter ", new CreateParameterUI()));
        options.add(new MenuItem("Register employee", new RegisterEmployeeUI()));
        options.add(new MenuItem("Register type of test", new RegisterTypeOfTestUI()));
        options.add(new MenuItem("Create a new Clinical Analysis Laboratory", new CreateClinicalAnalysisLabUI()));
        options.add(new MenuItem("Create a new Client", new RegisterClientUI()));
        options.add(new MenuItem("Leave ", new ShowTextUI("You have chosen Option C.")));

        int option = 0;
        do
        {
            option = Utils.showAndSelectIndex(options, "\n\nAdmin Menu:");

            if ( (option >= 0) && (option < options.size()))
            {
                options.get(option).run();
            }
        }
        while (option != -1 );
    }
}
