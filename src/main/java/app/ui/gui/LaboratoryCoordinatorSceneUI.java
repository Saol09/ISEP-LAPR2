package app.ui.gui;

        import app.ui.console.ValidateUI;
        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.fxml.Initializable;

        import java.net.URL;
        import java.util.ResourceBundle;
        import java.util.logging.Level;
        import java.util.logging.Logger;

public class LaboratoryCoordinatorSceneUI implements Initializable {
    private ApplicationFx applicationFx;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setMainApp(ApplicationFx applicationFx) {
        this.applicationFx = applicationFx;
    }

    @FXML
    public void btnValidateAction(ActionEvent event) {
        ValidateUI validateUI = new ValidateUI();
        validateUI.run();
    }

    @FXML
    public void btnImportDataAction(ActionEvent event){
        try {
            ImportDataSceneUI importDataSceneUI = (ImportDataSceneUI) this.applicationFx.replaceSceneContent("/fxml/ImportDataScene.fxml");
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
