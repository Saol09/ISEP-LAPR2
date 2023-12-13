
package app.ui.gui;

import app.controller.ImportDataController;
import app.controller.ReportNHSController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReportNHSSceneUI implements Initializable {
    @FXML
    public Button btnBack;
    public Button btnGen;
    public int Regression=0;
    public Label lblSucess;
    public Button btnMultiLinear;
    public Button btnLinear;
    public TextField txtDataFim;
    public TextField txtDataIni;
    private ApplicationFx applicationFx;
    ReportNHSController ctll = new ReportNHSController();

    public void setMainApp(ApplicationFx applicationFx) {
        this.applicationFx = applicationFx;
    }

    public void btnGen(ActionEvent actionEvent) {
            switch (Regression) {
                case 1:

                    if (ctll.LinearRegression(15, txtDataIni.getText(), txtDataFim.getText())) {
                        lblSucess.setText("Linear Regretion calculated, go to the folder NHSReport to see the results.");
                    } else {
                        lblSucess.setText("Error, couldnt find any test between that dates");}

                        break;
                        case 2:
                            if (ctll.MultLinearRegression(15, txtDataIni.getText(), txtDataFim.getText())) {
                                lblSucess.setText("Multi Linear Regretion calculated, go to the folder NHSReport to see the results.");
                            } else {
                                lblSucess.setText("Error, couldnt find any test between that dates");
                            }
                            break;
                        default:
                            lblSucess.setText("Please select the tipo of regression you want");

            }


    }

    public void btnBack(ActionEvent actionEvent) {
        try {
            AdminMenuUI importDataSceneUI = (AdminMenuUI) this.applicationFx.replaceSceneContent("/fxml/AdminMenu.fxml");
            importDataSceneUI.setMainApp(this.applicationFx);
        } catch (Exception ex) {
            Logger.getLogger(ApplicationFx.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void btnLinear(ActionEvent actionEvent) {
        Regression=1;
        String defaultStyle = btnLinear.getStyle();

        btnLinear.setStyle("-fx-background-color: #FFF");
        btnMultiLinear.setStyle(defaultStyle);
    }

    public void btnMultLinear(ActionEvent actionEvent) {
        Regression=2;
        String defaultStyle = btnMultiLinear.getStyle();

        btnLinear.setStyle("-fx-background-color: #FFF");
        btnMultiLinear.setStyle(defaultStyle);
        btnLinear.setStyle(defaultStyle);
        btnMultiLinear.setStyle("-fx-background-color: #FFF");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
