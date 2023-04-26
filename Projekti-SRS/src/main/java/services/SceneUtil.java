package services;

import controllers.StudentiIndividualViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.TableStudenti;

import java.io.IOException;

public class SceneUtil {
    public static void changeScene(Stage stage, String viewName) throws IOException {
        FXMLLoader loader = new FXMLLoader(SceneUtil.class.getResource(viewName));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    public static void changeSceneWithIdParameter(Stage stage, String viewName, int id) throws IOException{
        FXMLLoader loader = new FXMLLoader(SceneUtil.class.getResource(viewName));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        StudentiIndividualViewController controller = loader.getController();
        controller.initData(id);
        stage.setScene(scene);
    }
}
