package services;

import javafx.fxml.FXML;
import models.Admin;
import org.mindrot.jbcrypt.BCrypt;
import repository.AdminRepository;

import java.io.IOException;

public class AdminUtil {

    private Admin admin;
    public static boolean login(String username, String password){
        try{
            Admin admin_ = AdminRepository.getAdminByUsername(username);
            if(admin_ == null) {
                return false;
            }
            if(BCrypt.checkpw(password, admin_.getPassword())){
                this.admin=admin_;
                return true;
            }
            else{
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public static void saveNewPassword(String currentPassword, String newPassword, String confirmNewPassword) {
        try {

            if (!this.admin.getPassword().equals(currentPassword)) {
                System.out.println("Current password is incorrect");
                return;
            }

            if (!this.admin.equals(confirmNewPassword)) {
                System.out.println("New password and confirm password do not match");
                return;
            }
            this.admin.setPassword(newPassword);
            System.out.println("Password changed successfully");
        }catch(IOException e){

        }
    }
}
