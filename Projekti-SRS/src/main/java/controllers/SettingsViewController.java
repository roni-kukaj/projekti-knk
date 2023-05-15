package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import services.SceneUtil;

import java.io.IOException;


public class SettingsViewController {
    @FXML
    private Button goBackButton;
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
    public void saveNewPassword(String currentPassword, String newPassword, String confirmNewPassword) {
        try {

            if (!password.getPassword().equals(currentPassword)) {
                System.out.println("Current password is incorrect");
                return;
            }

            if (!newPassword.equals(confirmNewPassword)) {
                System.out.println("New password and confirm password do not match");
                return;
            }
            password.setPassword(newPassword);
            System.out.println("Password changed successfully");
        }catch(IOException e){

        }
    }

}
