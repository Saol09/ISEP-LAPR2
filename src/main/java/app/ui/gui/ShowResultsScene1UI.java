package app.ui.gui;

import app.controller.ShowResultsController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ShowResultsScene1UI implements Initializable {
    private ApplicationFx applicationFx;
    private ShowResultsController controller;

    @FXML
    private TextArea txtAreaTests;
    @FXML
    private TextField txtCode;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.controller = new ShowResultsController();
    }

    public void setMainApp(ApplicationFx applicationFx) {
        this.applicationFx = applicationFx;
    }

    public ShowResultsController getController(){
        return this.controller;
    }

    @FXML
    private void txtCode(ActionEvent event){
        this.txtCode.setText(null);
    }

    @FXML
    public void btnEnterAction(){
        this.controller.setTestCode(txtCode.getText());
        this.applicationFx.toShowResultsScene2(controller);
    }

    public void showResultsTests(){
        this.txtAreaTests.setText(this.controller.getTestsByClient());
    }

    @FXML
    private void btnCancelAction(ActionEvent event) {
        this.applicationFx.toClientScene();
    }


}
