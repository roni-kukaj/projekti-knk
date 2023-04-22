package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import repository.AdminRepository;

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

        boolean logged_in = AdminRepository.login(username, password);
        if(logged_in){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/projektisrs/DashboardView.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) this.loginButton.getScene().getWindow();
            stage.setScene(scene);
        }
    }
}
