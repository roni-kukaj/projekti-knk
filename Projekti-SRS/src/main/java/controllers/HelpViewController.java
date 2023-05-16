package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import services.AlertUtil;
import services.SceneUtil;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelpViewController extends BaseController {

    @FXML
    private Button dergoButton;
    @FXML
    private Button goBackButton;

    @FXML
    public void goToDashboard() {
        try{
            SceneUtil.changeScene((Stage)this.goBackButton.getScene().getWindow(), "/com/example/projektisrs/DashboardView.fxml");
        } catch (IOException e){
            AlertUtil.alertError("System Error", "Operation Failed", "This action could not be done!");

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.setMenuFunctions();
    }
}