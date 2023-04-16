package com.example.projektisrs;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(
                HelloApplication.class.getResource("HomeView.fxml")
        );
        AnchorPane studentsView = fxmlLoader.load();
        Scene scene = new Scene(studentsView);
        stage.setTitle("Sistemi për Regjistrimin e Studentëve");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}