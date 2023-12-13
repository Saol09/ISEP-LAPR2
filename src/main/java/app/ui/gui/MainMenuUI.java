package app.ui.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainMenuUI implements Initializable {

    private ApplicationFx mainApp;

    @FXML
    private Button btnLogin;
    @FXML
    private Button btnDevelopmentTeam;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    public void setMainApp(ApplicationFx mainApp) {
        this.mainApp = mainApp;
    }


    @FXML
    private void btnLoginAction(ActionEvent event) {
        try {
            LoginUI loginUI = (LoginUI) this.mainApp.replaceSceneContent("/fxml/Login.fxml");
            loginUI.setMainApp(this.mainApp);
        } catch (Exception ex) {
            Logger.getLogger(ApplicationFx.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnDevelopmentTeamAction(ActionEvent event){
        try{
            DevelopmentTeamUI developmentTeamUI = (DevelopmentTeamUI) this.mainApp.replaceSceneContent("/fxml/DevelopmentTeam.fxml");
            developmentTeamUI.setMainApp(this.mainApp);
        }catch (Exception ex){
            Logger.getLogger(ApplicationFx.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



}
