package services;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneUtil {
    public static void changeScene(Stage stage, String viewName) throws IOException {
        FXMLLoader loader = new FXMLLoader(SceneUtil.class.getResource(viewName));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }
}
