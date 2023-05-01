package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import services.SceneUtil;

import java.io.IOException;

public class HelpViewController {

    @FXML
    private Button dergoButton;
    @FXML
    private Button goBackButton;

    public void goToDashboard(){
        try {
            SceneUtil.changeScene((Stage) this.goBackButton.getScene().getWindow(), "/com/example/projektisrs/StudentsView.fxml");
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
    }
}