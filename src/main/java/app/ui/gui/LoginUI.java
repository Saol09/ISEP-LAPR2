package app.ui.gui;

import app.controller.AuthController;
import app.domain.shared.Constants;
import app.ui.console.SpecialistDoctorUI;
import auth.mappers.dto.UserRoleDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginUI implements Initializable {

    private MainMenuUI mainMenu;
    private ApplicationFx applicationFx;
    private AuthController controller;

    @FXML
    public Label lblLogin;
    @FXML
    public TextField txtEmail;
    @FXML
    public Label lblEmail;
    @FXML
    public Label lblPassword;
    @FXML
    private TextField txtPassword;
    @FXML
    private Button btnCancel;
    @FXML
    private Button btnEnter;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.controller = new AuthController();
    }

    public void setMainApp(ApplicationFx applicationFx) {
        this.applicationFx = applicationFx;
    }

    @FXML
    private void txtEmail(KeyEvent event) {
        this.txtEmail.setText(null);
    }

    @FXML
    private void txtPassword(KeyEvent event) {
        this.txtPassword.setText(null);
    }

    @FXML
    private void btnEnterAction(ActionEvent event) {
        boolean success;

        success = controller.doLogin(this.txtEmail.getText(), this.txtPassword.getText());

        if (success) {
            try {
                doLogin();
            } catch (Exception e) {
                Logger.getLogger(ApplicationFx.class.getName()).log(Level.SEVERE, null, e);
            }
        } else {
            try {
                LoginErrorUI loginErrorUI = (LoginErrorUI) this.applicationFx.replaceSceneContent("/fxml/LoginSceneError.fxml");
                loginErrorUI.setMainApp(applicationFx);
            } catch (Exception e) {
                Logger.getLogger(ApplicationFx.class.getName()).log(Level.SEVERE, null, e);
            }
        }


    }


    private void doLogin() {

        for (UserRoleDTO e : controller.getUserRoles()) {
            switch (e.getId()) {
                case Constants.ROLE_ADMIN:
                    try {
                        AdminMenuUI adminMenuUI = (AdminMenuUI) this.applicationFx.replaceSceneContent("/fxml/AdminMenu.fxml");
                        adminMenuUI.setMainApp(applicationFx);
                    } catch (Exception ex) {
                        Logger.getLogger(ApplicationFx.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case Constants.ROLE_CLIENT:
                    try {
                        ClientSceneUI clientSceneUI = (ClientSceneUI) this.applicationFx.replaceSceneContent("/fxml/ClientScene.fxml");
                        clientSceneUI.setMainApp(applicationFx);
                    } catch (Exception ex) {
                        Logger.getLogger(ApplicationFx.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;

                case Constants.ROLE_CLINICAL_CHEMISTRY_TEC:
                    try {
                        ClinicalChemistryTechnologistSceneUI clinicalChemistryTechnologistSceneUI = (ClinicalChemistryTechnologistSceneUI) this.applicationFx.replaceSceneContent("/fxml/ClinicalChemistryTechnologistScene.fxml");
                        clinicalChemistryTechnologistSceneUI.setMainApp(applicationFx);
                    } catch (Exception ex) {
                        Logger.getLogger(ApplicationFx.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;

                case Constants.ROLE_MEDICAL_LAB_TECHNICIAN:
                    try {
                        MedicalLabTechnicianSceneUI medicalLabTechnicianSceneUI = (MedicalLabTechnicianSceneUI) this.applicationFx.replaceSceneContent("/fxml/MedicalLabTechnicianScene.fxml");
                        medicalLabTechnicianSceneUI.setMainApp(applicationFx);
                    } catch (Exception ex) {
                        Logger.getLogger(ApplicationFx.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;

                case Constants.ROLE_LAB_COORDINATOR:
                    try {
                        LaboratoryCoordinatorSceneUI laboratoryCoordinatorSceneUI = (LaboratoryCoordinatorSceneUI) this.applicationFx.replaceSceneContent("/fxml/LaboratoryCoordinatorScene.fxml");
                        laboratoryCoordinatorSceneUI.setMainApp(applicationFx);
                    }catch (Exception ex){
                        Logger.getLogger(ApplicationFx.class.getName()).log(Level.SEVERE, null, ex);

                    }
                    break;

                case Constants.ROLE_SPECIALIST_DOCTOR:
                    try {
                        SpecialistDoctorSceneUI specialistDoctorSceneUI = (SpecialistDoctorSceneUI) this.applicationFx.replaceSceneContent("/fxml/SpecialistDoctorScene.fxml");
                        specialistDoctorSceneUI.setMainApp(applicationFx);
                    } catch (Exception ex) {
                        Logger.getLogger(ApplicationFx.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;

                case Constants.ROLE_RECEPTIONIST:
                    try {
                        ReceptionistSceneUI receptionistSceneUI = (ReceptionistSceneUI) this.applicationFx.replaceSceneContent("/fxml/ReceptionistScene.fxml");
                        receptionistSceneUI.setMainApp(applicationFx);
                    } catch (Exception ex) {
                        Logger.getLogger(ApplicationFx.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
            }
        }
    }

    @FXML
    private void btnCancelAction(ActionEvent event) {
        this.applicationFx.toMainScene();
    }

    private void logout() {
        controller.doLogout();
    }


}
