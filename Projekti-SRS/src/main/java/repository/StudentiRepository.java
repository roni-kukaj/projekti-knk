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
    ObservableList<TableStudenti>
    getStudentsForTable() throws SQLException
    {
        ObservableList<TableStudenti> data = FXCollections.observableArrayList();

        Connection connection =
                ConnectionUtil.getConnection();

        String sql = "SELECT * FROM Studenti";

        PreparedStatement

                preparedStatement =
                connection.prepareStatement(sql);
        ResultSet resultSet =
                preparedStatement.executeQuery();

        while(resultSet.next()){

            int id = resultSet.getInt("stuId");

            String firstName = resultSet.getString("Emri");
            String lastName = resultSet.getString("Mbiemri");
            String drejtimi = resultSet.getString("Drejtimi");

            TableStudenti studenti = new TableStudenti(id, firstName, lastName, drejtimi);

            data.add(studenti);
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
        return data;
    }
}