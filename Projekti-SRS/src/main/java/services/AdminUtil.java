package services;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import models.Admin;
import org.mindrot.jbcrypt.BCrypt;
import repository.AdminRepository;

import java.io.IOException;

public class AdminUtil {

    private static Admin admin;
    public static boolean login(String username, String password){
        try{
            Admin admin_ = AdminRepository.getAdminByUsername(username);
            if(admin_ == null) {
                return false;
            }
            if(BCrypt.checkpw(password, admin_.getPassword())){
                admin=admin_;
                return true;
            }
            else{
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean saveNewPassword(String currentPassword, String newPassword, String confirmNewPassword) {
        if(currentPassword.isEmpty()||newPassword.isEmpty()||confirmNewPassword.isEmpty()){
            AlertUtil.alertError("Imput Error", "Incorrect Input", "All fields are required");
            return false;
        }
        if (BCrypt.checkpw(currentPassword, admin.getPassword())) {
            if (newPassword.equals(confirmNewPassword)) {
                admin.setPassword(BCrypt.hashpw(newPassword, BCrypt.gensalt()));
                if (AdminRepository.updatePassword(admin)) {
                    return true;
                } else {
                    admin.setPassword(currentPassword);
                    AlertUtil.alertError("Operation Failed", "Password Error", "Sorry but your password could not be changed!");
                    return false;
                }
            } else {
                AlertUtil.alertError("Operation Failed", "Password Error", "Your passwords did not match!");
                return false;
            }
        } else {
            AlertUtil.alertError("Operation Failed", "Password Error", "Your current password was incorrect!");
            return false;
        }

    }

    public static void logOut(){
        admin=null;
    }
}
