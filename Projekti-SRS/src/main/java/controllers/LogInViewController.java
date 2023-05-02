package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import services.AdminUtil;
import services.SceneUtil;

import java.io.IOException;

public class LogInViewController {
    @FXML
    private TextField usernameTextfield;
    @FXML
    private TextField passwordTextfield;
    @FXML
    private Button loginButton;

    @FXML
    private void loginButtonClicked(ActionEvent e) throws IOException {
        String username = this.usernameTextfield.getText();
        String password = this.passwordTextfield.getText();

        boolean logged_in = AdminUtil.login(username, password);
        if(logged_in){
            try{
                SceneUtil.changeScene((Stage)this.loginButton.getScene().getWindow(), "/com/example/projektisrs/DashboardView.fxml");
            } catch(IOException ioe){
                // TO DO
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Error");
            alert.setHeaderText("Invalid login credentials");
            alert.setContentText("Please check your username and password and try again!");
            alert.showAndWait();
        }
    }
}
