package repository;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Studenti;
import models.TableStudenti;
import services.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentiRepository {
    public static
    ObservableList<TableStudenti> getStudentsForTable() throws SQLException {
        ObservableList<TableStudenti> data = FXCollections.observableArrayList();

        Connection connection = ConnectionUtil.getConnection();
        String sql = "SELECT * FROM Studenti";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next()){
            data.add(new TableStudenti(
                    resultSet.getInt("stuId"),
                    resultSet.getString("Emri"),
                    resultSet.getString("Mbiemri"),
                    resultSet.getString("Drejtimi")
            ));
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();

        return data;
    }
}