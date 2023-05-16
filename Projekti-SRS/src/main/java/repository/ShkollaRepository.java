package repository;

import models.Shkolla;
import services.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

    public static ArrayList<Shkolla> getShkollat() throws SQLException {
        ArrayList<Shkolla> data = new ArrayList<>();
        Connection connection = ConnectionUtil.getConnection();
        String sql = "SELECT * FROM Shkolla";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next()){
            data.add(
                    new Shkolla(
                            resultSet.getInt("SId"),
                            resultSet.getString("EmriIShkolles"),
                            resultSet.getInt("QId")
                    )
            );
        }
        return data;
    }
    public static ArrayList<Shkolla> getShkollatByQytetiId(int Qid) throws SQLException{
        ArrayList<Shkolla> data = new ArrayList<>();
        Connection connection = ConnectionUtil.getConnection();
        String sql = "SELECT * FROM Shkolla WHERE QId = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, Qid);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            data.add(
                    new Shkolla(
                            resultSet.getInt("SId"),
                            resultSet.getString("EmriIShkolles"),
                            resultSet.getInt("QId")
                    )
            );
        }
        return data;
    }


}