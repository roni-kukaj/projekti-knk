package controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Menu;
import javafx.stage.Stage;
import services.AlertUtil;
import services.SceneUtil;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public abstract class BaseController implements Initializable {
    @FXML
    public MenuItem newStudentMenuItem;
    @FXML
    public MenuItem updateStudentMenuItem;
    @FXML
    public MenuItem studentListMenuItem;
    @FXML
    public MenuItem exitMenuItem;
    @FXML
    public MenuItem makeGraphicsMenuItem;
    @FXML
    public MenuItem aboutMenuItem;
    @FXML
    public MenuBar menubar;
    @FXML
    public Menu fileMenu;
    @FXML
    public Menu graphicsMenu;
    @FXML
    public Menu helpMenu;

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
    public ResourceBundle getLangBundle(){
        Locale.setDefault(new Locale("en"));
        Locale currentLocale = Locale.getDefault();
        return ResourceBundle.getBundle("strings", currentLocale);
    }
    public abstract void labelContent(ResourceBundle translate);
    public void translate(){
        Locale locale = Locale.getDefault();
        ResourceBundle translate = ResourceBundle.getBundle(
                "translations.content", locale
        );
        this.labelContent(translate);
    }
    public void changeLangToAlb(){
        Locale.setDefault(new Locale("sq"));
        this.translate();
    }

    public void changeLangToEng(){
        Locale.setDefault(new Locale("en"));
        this.translate();
    }
}
