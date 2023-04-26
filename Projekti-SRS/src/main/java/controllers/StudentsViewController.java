package controllers;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import models.Studenti;
import models.TableStudenti;
import repository.StudentiRepository;
import services.SceneUtil;

import java.io.IOException;
import java.sql.SQLException;

public class StudentsViewController {
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

    public void initialize(){
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
                TableStudenti ts = this.studentTable.getSelectionModel().getSelectedItem();
                try {
                    SceneUtil.changeSceneWithParameter((Stage)this.goBackButton.getScene().getWindow(), "/com/example/projektisrs/StudentiIndividualView.fxml", ts);
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                }
            }
        });
    }

    public void filterButtonClicked(){
        String id = this.idFilterField.getText();
        String emri = this.emriFilterField.getText();
        String mbiemri = this.mbiemriFilterField.getText();
        try{
            if(id.equals("") & emri.equals("") & mbiemri.equals("")){
                studentiData = StudentiRepository.getTableStudenti();
            }
            else {
                if(id.equals(""))
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
}
