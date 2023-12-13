package app.ui.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class ShowResultsSceneErrorUI implements Initializable {

    private ApplicationFx applicationFx;

    @FXML
    public Button btnCancel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void setMainApp(ApplicationFx applicationFx) {
        this.applicationFx = applicationFx;
    }

    @FXML
    private void btnCancelAction(ActionEvent event) {
        this.applicationFx.toShowResultsScene1();
    }

}
