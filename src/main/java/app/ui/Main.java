package app.ui;

import app.controller.ImportDataService;
import app.domain.store.TestStore;
import app.ui.console.Bootstrap;
import app.ui.console.ConsultTestHistoryUI;
import app.ui.console.MainMenuUI;
import app.ui.gui.ApplicationFx;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class Main extends Application {

    public static void main(String[] args)
    {
        try
        {
            //DemoFile.writeFile("TESTE", "abc");
            Bootstrap bootstrap = new Bootstrap();
            /*
            ConsultTestHistoryUI s = new ConsultTestHistoryUI();
            s.run();

             */
            MainMenuUI menu = new MainMenuUI();

            //menu.run();

            //AdminUI adminUI = new AdminUI();
            //adminUI.run();


            launch(args);
        }
        catch( Exception e )
        {
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/MainMenu.fxml"));
        Scene scene = new Scene(root);
        ApplicationFx app = new ApplicationFx();
        app.start(stage);

    }
}
