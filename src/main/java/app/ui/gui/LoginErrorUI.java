package app.ui.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginErrorUI implements Initializable {

    private ApplicationFx applicationFx;

    @FXML
    public Label lblError;
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
       this.applicationFx.toLoginScene();
    }
}

