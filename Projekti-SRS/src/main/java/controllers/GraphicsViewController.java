package controllers;

import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import services.AlertUtil;
import services.DataUtil;
import services.FileUtil;
import services.SceneUtil;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;


public class GraphicsViewController extends BaseController {
    @FXML
    private Button goBackButton;
    @FXML
    private ChoiceBox<String> criteriaBox;
    @FXML
    private Button saveAsPNGButton;
    @FXML
    private PieChart chart;
    @FXML
    private Label formoGrafTextLabel;
    private ArrayList<PieChart.Data> data;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Locale locale = Locale.getDefault();
        ResourceBundle translate = ResourceBundle.getBundle(
                "translations.content", locale
        );
        labelContent(translate);
        this.setMenuFunctions();
        this.criteriaBox.getItems().addAll("Drejtim - Studentë", "Drejtim - Pikë Provim Pranues", "Qytet - Studentë");
        this.criteriaBox.setOnAction(e -> updateGraph());
        data = new ArrayList<>();
    }

    private void updateGraph() {
        try{
            this.chart.getData().clear();
            this.data = DataUtil.getData(this.criteriaBox.getValue());
            for(PieChart.Data d: this.data){
                this.chart.getData().add(d);
            }
        }
        catch (SQLException se){
            AlertUtil.alertError("Data Error", "Data not accessible", "We're sorry but this option is not available for the moment!");
        }
    }
    @FXML
    public void saveAsPNGButtonClicked(){
        FileUtil.saveBarChartAsPNG(this.chart, (Stage)this.saveAsPNGButton.getScene().getWindow());
    }

    public void goToDashboard(){
        try {
            SceneUtil.changeScene((Stage) this.goBackButton.getScene().getWindow(), "/com/example/projektisrs/DashboardView.fxml");
        } catch (IOException e) {
            AlertUtil.alertError("System Error", "Error", "We're sorry but this option is not available for the moment!");
        }
    }

    @Override
    public void labelContent(ResourceBundle translate) {
        this.formoGrafTextLabel.setText(translate.getString("graphics.formoGrafTextLabel.text"));
        this.saveAsPNGButton.setText(translate.getString("graphics.saveAsPNGButton.text"));
    }
}