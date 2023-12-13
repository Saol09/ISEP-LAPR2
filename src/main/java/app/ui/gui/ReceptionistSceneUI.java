package app.ui.gui;

import app.ui.console.RegisterClientUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class ReceptionistSceneUI implements Initializable {
    ApplicationFx applicationFx;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void setMainApp(ApplicationFx applicationFx) {
        this.applicationFx = applicationFx;
    }

    @FXML
    public void btnClientAction(ActionEvent event){
        RegisterClientUI registerClientUI = new RegisterClientUI();
        registerClientUI.run();
    }

    @FXML
    public void btnLogoutAction(ActionEvent event) {
        this.applicationFx.toLoginScene();
    }


}
