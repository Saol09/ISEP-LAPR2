package app.ui.gui;

import app.controller.ShowResultsController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ApplicationFx extends Application {
    private Stage stage;
    private final double MINIMUM_WINDOW_WIDTH = 950.0;
    private final double MINIMUM_WINDOW_HEIGHT = 700.0;
    private final double SCENE_WIDTH = 950.0;
    private final double SCENE_HEIGHT = 700.0;

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        stage.setTitle("Many Labs App by 0%Risk");
        stage.setMinWidth(MINIMUM_WINDOW_WIDTH);
        stage.setMinHeight(MINIMUM_WINDOW_HEIGHT);
        toMainScene();
        this.stage.show();
    }

    public Stage getStage() {
        return this.stage;
    }


    public void toMainScene() {
        try {
            MainMenuUI mainMenuUI = (MainMenuUI) replaceSceneContent("/fxml/MainMenu.fxml");
            mainMenuUI.setMainApp(this);
        } catch (Exception ex) {
            Logger.getLogger(ApplicationFx.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void toLoginScene(){
        try {
            LoginUI loginUI = (LoginUI) replaceSceneContent("/fxml/Login.fxml");
            loginUI.setMainApp(this);
        }catch (Exception ex){
            Logger.getLogger(ApplicationFx.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void toClientScene(){
        try{
            ClientSceneUI clientSceneUI = (ClientSceneUI) replaceSceneContent("/fxml/ClientScene.fxml");
            clientSceneUI.setMainApp(this);
        }catch (Exception ex){
            Logger.getLogger(ApplicationFx.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void toShowResultsScene1(){
        try{
            ShowResultsScene1UI showResultsScene1UI = (ShowResultsScene1UI) replaceSceneContent("/fxml/ShowResultsScene1.fxml");
            showResultsScene1UI.setMainApp(this);
        }catch (Exception ex){
            Logger.getLogger(ApplicationFx.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void toShowResultsScene2(ShowResultsController controller){
        try{
            ShowResultsScene2UI showResultsScene2UI = (ShowResultsScene2UI) replaceSceneContent("/fxml/ShowResultsScene2.fxml");
            showResultsScene2UI.setMainApp(this);
            showResultsScene2UI.setController(controller);
            showResultsScene2UI.showResultsAndReport();
        }catch (Exception ex){
            Logger.getLogger(ApplicationFx.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Initializable replaceSceneContent(String fxml) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        InputStream in = ApplicationFx.class.getResourceAsStream(fxml);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(ApplicationFx.class.getResource(fxml));
        Pane page;
        try {
            page = loader.load(in);
        } finally {
            in.close();
        }
        Scene scene = new Scene(page, SCENE_WIDTH, SCENE_HEIGHT);
        scene.getStylesheets().add("/styles/Styles.css");
        this.stage.setScene(scene);
        this.stage.sizeToScene();
        return  loader.getController();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
