package repository;

import models.Qyteti;
import models.Studenti;
import services.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}



# Shkolla repository

        package repository;

        import models.Qyteti;
        import models.Shkolla;
        import services.ConnectionUtil;

        import java.sql.Connection;
        import java.sql.PreparedStatement;
        import java.sql.ResultSet;
        import java.sql.SQLException;

public class ShkollaRepository {
    public static Shkolla getShkollaById(int id) throws SQLException {
        Connection connection = ConnectionUtil.getConnection();
        String sql = "SELECT * FROM Shkolla WHERE SId = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()){
            Shkolla shkolla = new Shkolla(
                    resultSet.getInt("SId"),
                    resultSet.getString("EmriIShkolles"),
                    resultSet.getInt("QId")
            );
            return shkolla;
        }
        else{
            return null;
        }
    }
}