package test;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class test1 extends Application {
    public void start(Stage stage){
        Pane pane = new Pane();
        Scene scene = new Scene(pane, 250, 250);
        stage.setScene(scene);
        stage.show();
    }
}
