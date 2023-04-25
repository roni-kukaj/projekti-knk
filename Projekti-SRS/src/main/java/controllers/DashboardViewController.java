package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import services.SceneUtil;

import java.io.IOException;


public class DashboardViewController {

    @FXML
    private Button registerStudentButton;

    @FXML
    private Button studentListButton;

    @FXML
    private Button updateStudentButton;

    @FXML
    private Button graphicsButton;

    @FXML
    private Button settingsButton;




    @FXML
    private void registerClicked(ActionEvent e) throws IOException {

            try {
                SceneUtil.changeScene((Stage)registerStudentButton.getScene().getWindow(), "/com/example/projektisrs/RegisterView.fxml");
            } catch(IOException ioe) {
                // TO DO
            }

    }

    @FXML
    private void studentClicked(ActionEvent e) throws IOException {

            try {
                SceneUtil.changeScene((Stage)studentListButton.getScene().getWindow(), "/com/example/projektisrs/StudentsView.fxml");
            } catch(IOException ioe) {
                // TO DO
            }

    }

    @FXML
    private void updateClicked(ActionEvent e) throws IOException {

            try {
                SceneUtil.changeScene((Stage)updateStudentButton.getScene().getWindow(), "/com/example/projektisrs/UpdateView.fxml");
            } catch(IOException ioe) {
                // TO DO
            }
        }


    @FXML
    private void graphicsClicked(ActionEvent e) throws IOException {

            try {
                SceneUtil.changeScene((Stage)graphicsButton.getScene().getWindow(), "/com/example/projektisrs/GraphicsView.fxml");
            } catch(IOException ioe) {
                // TO DO
            }
        }


    @FXML
    private void settingsClicked(ActionEvent e) throws IOException {

            try {
                SceneUtil.changeScene((Stage)settingsButton.getScene().getWindow(), "/com/example/projektisrs/SettingsView.fxml");
            } catch(IOException ioe) {
                // TO DO
            }
        }
    }

