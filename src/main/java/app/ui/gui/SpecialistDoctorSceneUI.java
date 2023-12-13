package app.ui.gui;

import app.ui.console.CreateDiagnosisReportUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class SpecialistDoctorSceneUI implements Initializable {
    private ApplicationFx applicationFx;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void setMainApp(ApplicationFx applicationFx) {
        this.applicationFx = applicationFx;
    }

    @FXML
    public void btnReportAction(ActionEvent event) {
        CreateDiagnosisReportUI createDiagnosisReportUI = new CreateDiagnosisReportUI();
        createDiagnosisReportUI.run();
    }

    @FXML
    public void btnLogoutAction(ActionEvent event) {
        this.applicationFx.toLoginScene();
    }

}
