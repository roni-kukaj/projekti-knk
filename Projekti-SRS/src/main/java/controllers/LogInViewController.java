package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import services.AdminUtil;
import services.AlertUtil;
import services.SceneUtil;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class LogInViewController implements Initializable {
    @FXML
    private TextField usernameTextfield;
    @FXML
    private TextField passwordTextfield;
    @FXML
    private Button loginButton;
    @FXML
    private Label usernameLabel;
    @FXML
    private Label passwordLabel;
    @FXML
    private Pane loginPane;

    @FXML
    public void onKeyPressedEvent(KeyEvent e) throws IOException {
        if(e.getCode() == KeyCode.ENTER){
            this.loginButtonClicked();
        }
    }

    public ResourceBundle getLangBundle(){
        Locale currentLocale = Locale.getDefault();
        return ResourceBundle.getBundle("strings", currentLocale);
    }
    @FXML
    private void loginButtonClicked() throws IOException {
        String username = this.usernameTextfield.getText();
        String password = this.passwordTextfield.getText();

        boolean logged_in = AdminUtil.login(username, password);
        if(logged_in){
            try{
                SceneUtil.changeScene((Stage)this.loginButton.getScene().getWindow(), "/com/example/projektisrs/DashboardView.fxml");
            } catch(IOException ioe){
                AlertUtil.alertError("Login Error", "Invalid Login Credentials", "Please check your username and password and try again!");
            }
        }
        else{
            AlertUtil.alertError("Login Error", "Invalid Login Credentials", "Please check your username and password and try again!");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Locale locale = Locale.getDefault();
        ResourceBundle translate = ResourceBundle.getBundle(
                "translations.content", locale
        );
        labelContent(translate);

        this.loginButton.setOnMouseEntered(e -> {
            this.loginButton.setStyle("-fx-background-color: #ffffff; -fx-text-fill: #38B6FF;");
        });
        this.loginButton.setOnMouseExited(e -> {
            this.loginButton.setStyle("-fx-background-color: #38B6FF; -fx-text-fill: #ffffff");
        });
    }

    public void translate(){
        Locale locale = Locale.getDefault();
        ResourceBundle translate = ResourceBundle.getBundle(
                "translations.content", locale
        );
        this.labelContent(translate);
    }

    public void labelContent(ResourceBundle translate){
        this.loginButton.setText(translate.getString("login.loginButton.text"));
        this.usernameLabel.setText(translate.getString("login.usernameLabel.text"));
        this.passwordLabel.setText(translate.getString("login.passwordLabel.text"));
    }

}
