package app.ui.gui;

import app.ui.console.CreateSampleTestUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class MedicalLabTechnicianSceneUI implements Initializable {
    private ApplicationFx applicationFx;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void setMainApp(ApplicationFx applicationFx) {
        this.applicationFx = applicationFx;
    }

    @FXML
    public void btnSampleAction(ActionEvent event) {
        CreateSampleTestUI createSampleTestUI = new CreateSampleTestUI();
        createSampleTestUI.run();
    }

    @FXML
    public void btnLogoutAction(ActionEvent event) {
        this.applicationFx.toLoginScene();
    }

}
