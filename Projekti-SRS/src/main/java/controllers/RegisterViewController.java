package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class RegisterViewController {


    public class LoginViewController {
        @FXML
        private TextField usernameTextfield;
        @FXML
        private TextField passwordTextfield;
        @FXML
        private Button loginButton;

        @FXML
        private void loginButtonClicked(ActionEvent e){
            String username = this.usernameTextfield.getText();
            String password = this.passwordTextfield.getText();

            System.out.println("Username: " + username + " - Password: " + password);
        }
    }

}
