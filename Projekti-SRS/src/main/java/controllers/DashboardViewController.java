package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import services.AdminUtil;
import services.AlertUtil;
import services.SceneUtil;
import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;


public class DashboardViewController extends BaseController {
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
    private Button logOutButton;
    @FXML
    private Button helpButton;
    @FXML
    private ImageView logo;

    @FXML
    private void registerClicked(ActionEvent e) throws IOException {

        try {
            SceneUtil.changeScene((Stage) registerStudentButton.getScene().getWindow(), "/com/example/projektisrs/RegisterView.fxml");
        } catch (IOException ioe) {
            AlertUtil.alertError("Operation Failed", "System Error", "This operation could not be done!");

        }

    }

    @FXML
    private void studentClicked(ActionEvent e) throws IOException {

        try {
            SceneUtil.changeScene((Stage) studentListButton.getScene().getWindow(), "/com/example/projektisrs/StudentsView.fxml");
        } catch (IOException ioe) {
            AlertUtil.alertError("Operation Failed", "System Error", "This operation could not be done!");

        }

    }

    @FXML
    private void updateClicked(ActionEvent e) throws IOException {

        try {
            SceneUtil.changeScene((Stage) updateStudentButton.getScene().getWindow(), "/com/example/projektisrs/UpdateView.fxml");
        } catch (IOException ioe) {
            AlertUtil.alertError("Operation Failed", "System Error", "This operation could not be done!");

        }
    }


    @FXML
    private void graphicsClicked(ActionEvent e) throws IOException {
        try {
            SceneUtil.changeScene((Stage) graphicsButton.getScene().getWindow(), "/com/example/projektisrs/GraphicsView.fxml");
        } catch (IOException ioe) {
            AlertUtil.alertError("Operation Failed", "System Error", "This operation could not be done!");

        }
    }

    @FXML
    private void settingsClicked(ActionEvent e) throws IOException {

        try {
            SceneUtil.changeScene((Stage) settingsButton.getScene().getWindow(), "/com/example/projektisrs/SettingsView.fxml");
        } catch (IOException ioe) {
            AlertUtil.alertError("Operation Failed", "System Error", "This operation could not be done!");
        }
    }

    @FXML
    private void  logOutClicked(ActionEvent e) throws IOException {
        try {
            AdminUtil.logOut();
            SceneUtil.changeScene((Stage) logOutButton.getScene().getWindow(), "/com/example/projektisrs/LogInView.fxml");
        } catch (IOException ioe) {
            AlertUtil.alertError("Operation Failed", "System Error", "This operation could not be done!");
        }

    }

    @FXML
    private void  helpClicked(ActionEvent e) throws IOException {
        try {
            SceneUtil.changeScene((Stage) helpButton.getScene().getWindow(), "/com/example/projektisrs/HelpView.fxml");
        } catch (IOException ioe) {
            AlertUtil.alertError("Operation Failed", "System Error", "This operation could not be done!");
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Locale locale = Locale.getDefault();
        ResourceBundle translate = ResourceBundle.getBundle(
                "translations.content", locale
        );
        labelContent(translate);
        this.setMenuFunctions();
    }

    @Override
    public void labelContent(ResourceBundle translate) {
        this.registerStudentButton.setText(translate.getString("dashboard.registerStudentButton.text"));
        this.studentListButton.setText(translate.getString("dashboard.studentListButton.text"));
        this.updateStudentButton.setText(translate.getString("dashboard.updateStudentButton.text"));
        this.graphicsButton.setText(translate.getString("dashboard.graphicsButton.text"));
        this.settingsButton.setText(translate.getString("dashboard.settingsButton.text"));
        this.logOutButton.setText(translate.getString("dashboard.logOut.text"));
    }
}
