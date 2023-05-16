package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import services.AdminUtil;
import services.AlertUtil;
import services.SceneUtil;

import java.io.IOException;
import java.net.URL;
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
        this.setMenuFunctions();
    }
}
