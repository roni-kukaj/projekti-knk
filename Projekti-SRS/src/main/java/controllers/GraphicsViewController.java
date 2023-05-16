package controllers;

import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import services.AlertUtil;
import services.DataUtil;
import services.SceneUtil;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class GraphicsViewController implements Initializable {
    @FXML
    private Button goBackButton;
    @FXML
    private ChoiceBox<String> criteriaBox;
    @FXML
    private BarChart<String, Number> chart;
    private XYChart.Series<String, Number> series;
    private CategoryAxis xAxis;
    private NumberAxis yAxis;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.criteriaBox.getItems().addAll("Drejtim - Studentë", "Drejtim - Pikë Provim Pranues", "Qytet - Studentë");
        this.criteriaBox.setOnAction(e -> updateGraph());
        series = new XYChart.Series<>();
    }

    private void updateGraph() {
        try{
            this.chart.getData().clear();
            this.series.getData().clear();
            this.chart.getXAxis().setAutoRanging(true);
            this.series = DataUtil.getChartData(this.criteriaBox.getValue());
            this.chart.getData().add(this.series);
        }
        catch (SQLException se){
            AlertUtil.alertError("Data Error", "Data not accessible", "We're sorry but this option is not available for the moment!");
        }
    }

    public void goToDashboard(){
        try {
            SceneUtil.changeScene((Stage) this.goBackButton.getScene().getWindow(), "/com/example/projektisrs/DashboardView.fxml");
        } catch (IOException e) {
            AlertUtil.alertError("System Error", "Error", "We're sorry but this option is not available for the moment!");
        }
    }
}
