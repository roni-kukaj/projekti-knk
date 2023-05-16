package controllers;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import models.Studenti;
import models.TableStudenti;
import repository.StudentiRepository;
import services.AlertUtil;
import services.SceneUtil;
import services.TypeUtil;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

public class StudentsViewController extends BaseController {
    @FXML
    private Button goBackButton;
    @FXML
    private TextField idFilterField;
    @FXML
    private TextField emriFilterField;
    @FXML
    private TextField mbiemriFilterField;
    @FXML
    private Button filterButton;
    @FXML
    private TableView<TableStudenti> studentTable;
    @FXML
    private TableColumn<TableStudenti, Integer> idColumn;
    @FXML
    private TableColumn<TableStudenti, String> emriColumn;
    @FXML
    private TableColumn<TableStudenti, String> mbiemriColumn;
    @FXML
    private TableColumn<TableStudenti, String> drejtimiColumn;

    private ObservableList<TableStudenti> studentiData;

    public void filterButtonClicked(){
        String id = this.idFilterField.getText();
        String emri = this.emriFilterField.getText();
        String mbiemri = this.mbiemriFilterField.getText();
        try{
            if(id.equals("") & emri.equals("") & mbiemri.equals("")){
                studentiData = StudentiRepository.getTableStudenti();
            }
            else {
                if(id.equals("") || !TypeUtil.isNumeric(id))
                    id = "0";
                studentiData = StudentiRepository.filterTableStudenti(Integer.parseInt(id), emri, mbiemri);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        studentTable.setItems(studentiData);
        idFilterField.clear();
        emriFilterField.clear();
        mbiemriFilterField.clear();
    }
    @FXML
    public void goToDashboard() {
        try{
            SceneUtil.changeScene((Stage)this.goBackButton.getScene().getWindow(), "/com/example/projektisrs/DashboardView.fxml");
        } catch (IOException e){
            e.printStackTrace();
            return;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Locale.setDefault(new Locale("sq"));
        Locale locale = Locale.getDefault();
        ResourceBundle translate = ResourceBundle.getBundle(
                "translations.content", locale
        );
        labelContent(translate);
        this.setMenuFunctions();
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        emriColumn.setCellValueFactory(new PropertyValueFactory<>("emri"));
        mbiemriColumn.setCellValueFactory(new PropertyValueFactory<>("mbiemri"));
        drejtimiColumn.setCellValueFactory(new PropertyValueFactory<>("drejtimi"));

        try{
            studentiData = StudentiRepository.getTableStudenti();
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        studentTable.setItems(studentiData);

        this.studentTable.setOnMouseClicked(event -> {
            if(event.getClickCount() == 2){
                try {
                    TableStudenti ts = this.studentTable.getSelectionModel().getSelectedItem();
                    SceneUtil.changeSceneWithIdParameter((Stage)this.goBackButton.getScene().getWindow(), "/com/example/projektisrs/StudentiIndividualView.fxml", ts.getId());
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                }
                catch(Exception ee){
                    AlertUtil.alertError("Data Error", "Data Error", "Something went wrong!");
                    return;
                }
            }
        });
    }

    @Override
    public void labelContent(ResourceBundle translate) {
        this.idFilterField.setText(translate.getString("students.idFilterField.promptText"));
        this.emriFilterField.setText(translate.getString("students.emriFilterField.promptText"));
        this.mbiemriFilterField.setText(translate.getString("students.mbiemriFilterField.promptText"));
        this.filterButton.setText(translate.getString("students.filterButton.text"));
        this.idColumn.setText(translate.getString("students.idColumn.text"));
        this.emriColumn.setText(translate.getString("students.emriColumn.text"));
        this.mbiemriColumn.setText(translate.getString("students.mbiemriColumn.text"));
        this.drejtimiColumn.setText(translate.getString("students.drejtimiColumn.text"));
    }
}
