package controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import services.AlertUtil;
import services.SceneUtil;

import java.io.IOException;

public abstract class BaseController implements Initializable {
    @FXML
    private MenuItem newStudentMenuItem;
    @FXML
    private MenuItem updateStudentMenuItem;
    @FXML
    private MenuItem studentListMenuItem;
    @FXML
    private MenuItem exitMenuItem;
    @FXML
    private MenuItem makeGraphicsMenuItem;
    @FXML
    private MenuItem aboutMenuItem;
    @FXML
    private MenuBar menubar;

    public void setMenuFunctions() {
        this.newStudentMenuItem.setOnAction(e -> {
            try {
                SceneUtil.changeScene((Stage)this.menubar.getScene().getWindow(), "/com/example/projektisrs/RegisterView.fxml");
            } catch (IOException ex) {
                AlertUtil.alertError("System Error", "Window Error", "Sorry but this action could not be completed!");
            }
        });
        this.updateStudentMenuItem.setOnAction(e -> {
            try {
                SceneUtil.changeScene((Stage)this.menubar.getScene().getWindow(), "/com/example/projektisrs/UpdateView.fxml");
            } catch (IOException ex) {
                AlertUtil.alertError("System Error", "Window Error", "Sorry but this action could not be completed!");
            }
        });
        this.studentListMenuItem.setOnAction(e -> {
            try {
                SceneUtil.changeScene((Stage)this.menubar.getScene().getWindow(), "/com/example/projektisrs/StudentsView.fxml");
            } catch (IOException ex) {
                AlertUtil.alertError("System Error", "Window Error", "Sorry but this action could not be completed!");
            }
        });
        this.exitMenuItem.setOnAction(e -> {
            System.exit(0);
        });
        this.makeGraphicsMenuItem.setOnAction(e -> {
                Platform.exit();
        });
        this.aboutMenuItem.setOnAction(e -> {
            try {
                SceneUtil.changeScene((Stage)this.menubar.getScene().getWindow(), "/com/example/projektisrs/HelpView.fxml");
            } catch (IOException ex) {
                AlertUtil.alertError("System Error", "Window Error", "Sorry but this action could not be completed!");
            }
        });
    }
}
