package app.ui.gui;

import app.controller.App;
import app.controller.ShowResultsController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ShowResultsScene2UI implements Initializable {
    private ApplicationFx applicationFx;
    private ShowResultsController controller;
    private ShowResultsScene1UI showResultsScene1UI;

    @FXML
    public Button btnYes;
    @FXML
    public Button btnNo;
    @FXML
    public TextArea txtAreaInfoTest;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    public void setController(ShowResultsController controller){
        this.controller = controller;
    }

    public void setMainApp(ApplicationFx applicationFx) {
        this.applicationFx = applicationFx;
    }

    @FXML
    private void btnYesAction(ActionEvent event) {
        try{
            ShowResultsScene1UI showResultsScene1UI = (ShowResultsScene1UI) this.applicationFx.replaceSceneContent("/fxml/ShowResultsScene1.fxml");
            showResultsScene1UI.setMainApp(this.applicationFx);
            showResultsScene1UI.showResultsTests();
        }catch (Exception ex){
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnNoAction(ActionEvent event){
        this.applicationFx.toClientScene();
    }

    public void showResultsAndReport(){
        this.txtAreaInfoTest.setText(this.controller.getTestResultsAndReport());
    }

}
