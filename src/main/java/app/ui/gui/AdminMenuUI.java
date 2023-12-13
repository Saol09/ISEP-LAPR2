package app.ui.gui;

import app.ui.console.*;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminMenuUI implements Initializable {
    private ApplicationFx applicationFx;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void setMainApp(ApplicationFx applicationFx) {
        this.applicationFx = applicationFx;
    }

    public void btnRegisterEmployeeAction(ActionEvent event) {
        RegisterEmployeeUI registerEmployeeUI = new RegisterEmployeeUI();
        registerEmployeeUI.run();

    }

    public void btnRegisterLabAction(ActionEvent event) {
        CreateClinicalAnalysisLabUI createClinicalAnalysisLabUI = new CreateClinicalAnalysisLabUI();
        createClinicalAnalysisLabUI.run();
    }

    public void btnTypeOfTestAction(ActionEvent event) {
        RegisterTypeOfTestUI registerTypeOfTestUI = new RegisterTypeOfTestUI();
        registerTypeOfTestUI.run();
    }

    public void btnParameterAction(ActionEvent event) {
        CreateParameterUI createParameterUI = new CreateParameterUI();
        createParameterUI.run();
    }

    public void btnParameterCategoryAction(ActionEvent event) {
        CreateParameterCategoryUI createParameterCategoryUI = new CreateParameterCategoryUI();
        createParameterCategoryUI.run();
    }

    public void btnSendReportAction(ActionEvent event) {
        CreateDiagnosisReportUI createDiagnosisReportUI = new CreateDiagnosisReportUI();
        createDiagnosisReportUI.run();
    }



    public void btnLogoutAction(ActionEvent event){
        this.applicationFx.toLoginScene();
    }

    public void btnReportNHS(ActionEvent actionEvent) {
        try {
            ReportNHSSceneUI importDataSceneUI = (ReportNHSSceneUI) this.applicationFx.replaceSceneContent("/fxml/ReportNHSScene.fxml");
            importDataSceneUI.setMainApp(this.applicationFx);
        } catch (Exception ex) {
            Logger.getLogger(ApplicationFx.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
