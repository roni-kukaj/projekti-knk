package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import services.SceneUtil;

import java.io.IOException;

public class GraphicsViewController {
    @FXML
    private Button goBackButton;

    public void goToDashboard(){
        try {
            SceneUtil.changeScene((Stage) this.goBackButton.getScene().getWindow(), "/com/example/projektisrs/DashboardView.fxml");
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
    }
}
