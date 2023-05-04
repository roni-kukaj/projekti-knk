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

    public static ArrayList<Qyteti> getQytetet() throws SQLException {
        ArrayList<Qyteti> data = new ArrayList<>();

        Connection connection = ConnectionUtil.getConnection();
        String sql = "SELECT * FROM Qyteti";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next()){
            data.add(new Qyteti(
                    resultSet.getInt("QId"),
                    resultSet.getString("Emri")
            ));
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();

        return data;
    }
    public static ArrayList<String> getQytetiNames() throws SQLException {
        Connection connection = ConnectionUtil.getConnection();
        String sql = "SELECT Emri FROM Qyteti";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        ArrayList<String> qytetet = new ArrayList<>();
        while(resultSet.next()){
            qytetet.add(resultSet.getString(1));
        }
        return qytetet;
    }
}