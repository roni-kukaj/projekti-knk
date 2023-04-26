package services;

import models.Admin;
import org.mindrot.jbcrypt.BCrypt;
import repository.AdminRepository;

public class AdminService {
    public static boolean login(String username, String password){
        try{
            Admin admin = AdminRepository.getAdminByUsername(username);
            if(admin == null) {
                return false;
            }
            if(BCrypt.checkpw(password, admin.getPassword())){
                return true;
            }
            else{
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
