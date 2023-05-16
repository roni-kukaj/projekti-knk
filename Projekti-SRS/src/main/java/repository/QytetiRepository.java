package repository;

import models.Qyteti;
import models.Studenti;
import services.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QytetiRepository {
    public static Qyteti getQytetiById(int id) throws SQLException {
        Connection connection = ConnectionUtil.getConnection();
        String sql = "SELECT * FROM Qyteti WHERE QId = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()){
            Qyteti qyteti = new Qyteti(
                    resultSet.getInt("QId"),
                    resultSet.getString("Emri")
            );
            return qyteti;
        }
        else{
            return null;
        }
    }