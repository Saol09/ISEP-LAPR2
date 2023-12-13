package app.ui.gui;

import app.controller.ImportDataController;
import app.controller.ShowResultsController;
import app.ui.console.LaboratoryCoordinatorUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ImportDataSceneUI implements Initializable {

    private ApplicationFx applicationFx;
    ImportDataController ctll = new ImportDataController();
    @FXML
    public TextArea txtAreaPath;
    @FXML
    public TextArea txtAreaInfo;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void setMainApp(ApplicationFx applicationFx) {
        this.applicationFx = applicationFx;
    }

    public void btnImportData(ActionEvent actionEvent) {
        txtAreaInfo.setText("Importing");
        txtAreaInfo.setText(ctll.ImportData(txtAreaPath.getText()));

    }

    public void btnback(ActionEvent actionEvent) {
        try {
            LaboratoryCoordinatorSceneUI importDataSceneUI = (LaboratoryCoordinatorSceneUI) this.applicationFx.replaceSceneContent("/fxml/LaboratoryCoordinatorScene.fxml");
            importDataSceneUI.setMainApp(this.applicationFx);
        } catch (Exception ex) {
            Logger.getLogger(ApplicationFx.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
