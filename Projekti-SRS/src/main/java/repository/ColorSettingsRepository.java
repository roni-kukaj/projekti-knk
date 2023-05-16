package repository;

import services.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ColorSettingsRepository {
    public String getColor() throws SQLException {
        Connection connection = ConnectionUtil.getConnection();
        String sql = "SELECT color FROM ColorSettings WHERE id=1 LIMIT 1";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            return resultSet.getString(1);
        }
        return null;
    }
    public String getLogo() throws SQLException {
        Connection connection = ConnectionUtil.getConnection();
        String sql = "SELECT logo FROM ColorSettings WHERE id=1 LIMIT 1";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            return resultSet.getString(1);
        }
        return null;
    }
    public String getRegisterLogo() throws SQLException {
        Connection connection = ConnectionUtil.getConnection();
        String sql = "SELECT registerlogo FROM ColorSettings WHERE id=1 LIMIT 1";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            return resultSet.getString(1);
        }
        return null;
    }
    public String getStudentLogo() throws SQLException {
        Connection connection = ConnectionUtil.getConnection();
        String sql = "SELECT studentlogo FROM ColorSettings WHERE id=1 LIMIT 1";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            return resultSet.getString(1);
        }
        return null;
    }
    public String getUpdateLogo() throws SQLException {
        Connection connection = ConnectionUtil.getConnection();
        String sql = "SELECT updatelogo FROM ColorSettings WHERE id=1 LIMIT 1";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            return resultSet.getString(1);
        }
        return null;
    }
    public String getGraphicsLogo() throws SQLException {
        Connection connection = ConnectionUtil.getConnection();
        String sql = "SELECT graphicslogo FROM ColorSettings WHERE id=1 LIMIT 1";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            return resultSet.getString(1);
        }
        return null;
    }
    public String getSettingsLogo() throws SQLException {
        Connection connection = ConnectionUtil.getConnection();
        String sql = "SELECT settingslogo FROM ColorSettings WHERE id=1 LIMIT 1";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            return resultSet.getString(1);
        }
        return null;
    }
}
