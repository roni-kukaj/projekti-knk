package repository;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Shkolla;
import models.Studenti;
import models.TableStudenti;
import models.dto.CreateStudentDto;
import services.AlertUtil;
import services.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentiRepository {
    public static ObservableList<TableStudenti> getTableStudenti() throws SQLException {
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
    public static ObservableList<TableStudenti> getTableStudentiById(int id) throws SQLException {
        ObservableList<TableStudenti> data = FXCollections.observableArrayList();

        Connection connection = ConnectionUtil.getConnection();
        String sql = "SELECT * FROM Studenti where stuId = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
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
    public static ObservableList<TableStudenti> getTableStudentiByEmri(String emri) throws SQLException {
        ObservableList<TableStudenti> data = FXCollections.observableArrayList();

        Connection connection = ConnectionUtil.getConnection();
        String sql = "SELECT * FROM Studenti where Emri LIKE ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, emri);
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
    public static ObservableList<TableStudenti> getTableStudentiByMbiemri(String mbiemri) throws SQLException {
        ObservableList<TableStudenti> data = FXCollections.observableArrayList();

        Connection connection = ConnectionUtil.getConnection();
        String sql = "SELECT * FROM Studenti where Mbiemri LIKE ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, mbiemri);
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
    public static ObservableList<TableStudenti> filterTableStudenti(int id, String emri, String mbiemri) throws SQLException{
        ObservableList<TableStudenti> data = FXCollections.observableArrayList();

        Connection connection = ConnectionUtil.getConnection();
        String sql = "SELECT * FROM Studenti WHERE stuId = ? OR Emri LIKE ? OR Mbiemri LIKE ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        preparedStatement.setString(2, emri);
        preparedStatement.setString(3, mbiemri);
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
    public static Studenti getStudentiById(int id) throws SQLException{
        Connection connection = ConnectionUtil.getConnection();
        String sql = "SELECT * FROM Studenti WHERE stuId = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next())
            return new Studenti(
                    resultSet.getInt("stuId"),
                    resultSet.getString("Emri"),
                    resultSet.getString("Mbiemri"),
                    resultSet.getString("Gjinia").charAt(0),
                    resultSet.getDate("Ditelindja"),
                    resultSet.getString("Email"),
                    resultSet.getInt("QytetiILindjes"),
                    resultSet.getInt("Komuna"),
                    resultSet.getInt("SId"),
                    resultSet.getDouble("SuksesiNeSHM"),
                    resultSet.getInt("PiketEMatures"),
                    resultSet.getInt("PiketEProvimitPranues"),
                    resultSet.getString("Drejtimi")
            );
        else
            return null;
    }

    public static boolean insert(CreateStudentDto studentDto) {
        try {
            Connection connection = ConnectionUtil.getConnection();
            String sql = "INSERT INTO Studenti(Emri, Mbiemri, Gjinia, Ditelindja, Email, QytetiILindjes, Komuna, SuksesiNeSHM, PiketEMatures, PiketEProvimitPranues, Drejtimi, SId)" +
                    " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, studentDto.getEmri());
            statement.setString(2, studentDto.getMbiemri());
            statement.setString(3, String.valueOf(studentDto.getGjinia()));
            statement.setObject(4, studentDto.getDitelindja());
            statement.setString(5, studentDto.getEmail());
            statement.setInt(6, studentDto.getQytetiLindjesId());
            statement.setInt(7, studentDto.getKomunaId());
            statement.setObject(8, studentDto.getSuksesiNeShkollenMesme());
            statement.setInt(9, studentDto.getPiketTestitMatures());
            statement.setInt(10, studentDto.getPiketProvimitPranues());
            statement.setString(11, studentDto.getDrejtimi());
            statement.setInt(12, studentDto.getShkollaId());
            statement.executeQuery();
            return true;
        } catch (SQLException e){
            return false;
        }
    }
}