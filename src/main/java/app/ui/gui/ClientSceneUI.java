package app.ui.gui;

import app.controller.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientSceneUI implements Initializable {
    private ApplicationFx applicationFx;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setMainApp(ApplicationFx applicationFx) {
        this.applicationFx = applicationFx;
    }

    @FXML
    public void btnViewResultsAction(ActionEvent event){
        try{
            ShowResultsScene1UI showResultsScene1UI = (ShowResultsScene1UI) this.applicationFx.replaceSceneContent("/fxml/ShowResultsScene1.fxml");
            showResultsScene1UI.setMainApp(this.applicationFx);
            showResultsScene1UI.showResultsTests();
        }catch (Exception ex){
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*
    try {
            ShowEmployeesUI showEmployeesUI = (ShowEmployeesUI) this.mainApp.
                    replaceSceneContent("/fxml/ShowEmployees.fxml");
            showEmployeesUI.setMainApp(this.mainApp);
            showEmployeesUI.showEmployees();
        } catch (Exception ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
     */

    @FXML
    public void btnLogoutAction(ActionEvent event){
        this.applicationFx.toLoginScene();
    }


}
