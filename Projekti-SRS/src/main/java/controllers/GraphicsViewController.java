package controllers;

import javafx.scene.Scene;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import services.SceneUtil;

import java.io.IOException;


public class GraphicsViewController {

    public class GraphApplication extends Application {

        private XYChart.Series<Number, Number> dataSeries = new XYChart.Series<>();

        public void start(Stage primaryStage) throws Exception {
            // Create the axes for the graph
            final NumberAxis xAxis = new NumberAxis();
            final NumberAxis yAxis = new NumberAxis();
            xAxis.setLabel("X");
            yAxis.setLabel("Y");

            // Create the line chart and add it to the scene
            final LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
            lineChart.setTitle("Graph");
            lineChart.getData().add(dataSeries);
            Scene scene = new Scene(lineChart, 800, 600);

            // Update the graph when the criteria changes
            updateGraph(0); // initialize with default criteria
            Criteria criteria = new Criteria();
            criteria.addListener((obs, oldCriteria, newCriteria) -> updateGraph(newCriteria));

            // Show the scene
            primaryStage.setScene(scene);
            primaryStage.show();
        }

        private void updateGraph(int criteria) {
            // Generate some sample data based on the criteria
            dataSeries.getData().clear();
            for (int i = 0; i <= 10; i++) {
                double y = Math.random() * (criteria + 1);
                dataSeries.getData().add(new XYChart.Data<>(i, y));
            }
        }

        public void main(String[] args) {
            launch(args);
        }

        // Dummy class to represent the criteria
        private class Criteria {
            private int value;

            public int getValue() {
                return value;
            }

            public void setValue(int value) {
                this.value = value;
            }

            public void addListener(ChangeListener<? super Integer> listener) {
                // implement listener registration here
            }
        }
    }

    @FXML
    private Button goBackButton;

    public void goToDashboard(){
        try {
            SceneUtil.changeScene((Stage) this.goBackButton.getScene().getWindow(), "/com/example/projektisrs/DashboardView.fxml");
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
    }
}
