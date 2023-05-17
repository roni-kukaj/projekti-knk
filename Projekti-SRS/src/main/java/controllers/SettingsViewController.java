package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import services.AdminUtil;
import services.AlertUtil;
import services.SceneUtil;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;


public class SettingsViewController extends BaseController {
    @FXML
    private Button goBackButton;
    @FXML
    private Button saveProfileButton;
    @FXML
    private PasswordField currentPasswordField;
    @FXML
    private PasswordField newPasswordField;
    @FXML
    private PasswordField confirmPasswordField;
    @FXML
    private Tab profileSettingsTab;
    @FXML
    private Tab sysSettingsTab;
    @FXML
    private Button albFlagButton;
    @FXML
    private Button usaFlagButton;
    @FXML
    private Label currentPsw;
    @FXML
    private Label newPsw;
    @FXML
    private Label confirmPsw;
    @FXML
    private Label systemLanguageLabel;

    @FXML
    public void goToDashboard() {

        try{
            SceneUtil.changeScene((Stage)this.goBackButton.getScene().getWindow(), "/com/example/projektisrs/DashboardView.fxml");
        } catch (IOException e){
            e.printStackTrace();
            return;
        }
    }

    @FXML
    public void saveNewPassword(){
        String currentPassword=this.currentPasswordField.getText();
        String newPassword=this.newPasswordField.getText();
        String confirmNewPassword=this.confirmPasswordField.getText();
        if(AdminUtil.saveNewPassword(currentPassword, newPassword, confirmNewPassword)){
            AlertUtil.alertSuccess("Operation Success", "Your password has been changed successfully");
            this.currentPasswordField.clear();
            this.newPasswordField.clear();
            this.confirmPasswordField.clear();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Locale locale = Locale.getDefault();
        ResourceBundle translate = ResourceBundle.getBundle(
                "translations.content", locale
        );
        labelContent(translate);
        this.setMenuFunctions();
        this.albFlagButton.setOnAction(e -> {
            this.changeLangToAlb();
        });
        this.usaFlagButton.setOnAction(e -> {
            this.changeLangToEng();
        });
    }

    public void labelContent(ResourceBundle translate){
        this.profileSettingsTab.setText(translate.getString("settings.profileSettingsTab.text"));
        this.sysSettingsTab.setText(translate.getString("settings.sysSettingsTab.text"));
        this.currentPsw.setText(translate.getString("settings.currentPsw.text"));
        this.newPsw.setText(translate.getString("settings.newPsw.text"));
        this.confirmPsw.setText(translate.getString("settings.confirmPsw.text"));
        this.saveProfileButton.setText(translate.getString("settings.saveProfileButton.text"));
        this.systemLanguageLabel.setText(translate.getString("settings.systemLanguageLabel.text"));
    }
}
