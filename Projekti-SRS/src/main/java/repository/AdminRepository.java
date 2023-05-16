package repository;

import models.Admin;
import org.mindrot.jbcrypt.BCrypt;
import services.ConnectionUtil;

import java.sql.*;

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

    public static boolean updatePassword(Admin admin){
        try{
            Connection connection = ConnectionUtil.getConnection();
            String sql="UPDATE Admin SET Password = ? WHERE AId = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, admin.getPassword());
            statement.setInt(2, admin.getAdminId());
            statement.executeUpdate();
            return true;
        }catch (SQLException e){
            return false;
        }
    }
}
