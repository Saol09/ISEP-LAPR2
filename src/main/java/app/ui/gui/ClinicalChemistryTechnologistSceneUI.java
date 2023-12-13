package app.ui.gui;

import app.ui.console.RecordTestResultUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClinicalChemistryTechnologistSceneUI implements Initializable {
    ApplicationFx applicationFx;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void setMainApp(ApplicationFx applicationFx) {
        this.applicationFx = applicationFx;
    }

    @FXML
    public void btnRecordAction(ActionEvent event){
        RecordTestResultUI recordTestResultUI = new RecordTestResultUI();
        recordTestResultUI.run();
    }

    @FXML
    public void btnConsultAction(ActionEvent event){
        try {
            ConsultTestHistorySceneUI importDataSceneUI = (ConsultTestHistorySceneUI) this.applicationFx.replaceSceneContent("/fxml/ConsultTestHistoryScene.fxml");
            importDataSceneUI.setMainApp(this.applicationFx);
        } catch (Exception ex) {
            Logger.getLogger(ApplicationFx.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    public void btnLogoutAction(ActionEvent event) {
        this.applicationFx.toLoginScene();
    }




}
