package app.ui.gui;

import app.controller.ConsultTestHistoryController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsultTestHistorySceneUI implements Initializable {
    @FXML
    public TextArea txtAreaPath;
    @FXML
    public TextArea txtAreaInfo;
    ApplicationFx applicationFx;

    private ConsultTestHistoryController ctrl = new ConsultTestHistoryController();
    public void btnSearch(ActionEvent actionEvent) {
        txtAreaInfo.setText("Test performed:\n"+ctrl.getClientTests(txtAreaInfo.getText()));

    }
    public void setMainApp(ApplicationFx applicationFx) {
        this.applicationFx = applicationFx;
    }
    public void btnback(ActionEvent actionEvent) {
        try {
            ClinicalChemistryTechnologistSceneUI importDataSceneUI = (ClinicalChemistryTechnologistSceneUI) this.applicationFx.replaceSceneContent("/fxml/ClinicalChemistryTechnologistScene.fxml");
            importDataSceneUI.setMainApp(this.applicationFx);
        } catch (Exception ex) {
            Logger.getLogger(ApplicationFx.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txtAreaInfo.setText(ctrl.getClientOrder());
    }
}
