package repository;

import models.Admin;
import org.mindrot.jbcrypt.BCrypt;
import services.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminRepository {
    public static Admin getAdminByUsername(String username){
        String sql = "SELECT * FROM Admin WHERE username = ?";
        try{
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            ResultSet result = statement.executeQuery();
            if(result.next()){
                int id = result.getInt(1);
                String username_ = result.getString(2);
                String password = result.getString(3);
                return new Admin(id, username_, password);
            }
            else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }

    public static boolean login(String username, String password){
        try{
            Admin admin = AdminRepository.getAdminByUsername(username);
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
