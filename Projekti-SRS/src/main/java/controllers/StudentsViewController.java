package controllers;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Studenti;
import models.TableStudenti;
import repository.StudentiRepository;

import java.sql.SQLException;

public class StudentsViewController {
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
    }

    public void filterButtonClicked(){
        String id = this.idFilterField.getText();
        String emri = this.emriFilterField.getText();
        String mbiemri = this.mbiemriFilterField.getText();
        try{
            if(id.equals("") & emri.equals("") & mbiemri.equals("")){
                studentiData = StudentiRepository.getTableStudenti();
            }
            else if(emri.equals("") & mbiemri.equals("")){
                studentiData = StudentiRepository.getTableStudentiById(Integer.parseInt(id));
            }
            else if(id.equals("") & mbiemri.equals("")){
                studentiData = StudentiRepository.getTableStudentiByEmri(emri);
            }
            else if(id.equals("") & emri.equals("")){
                studentiData = StudentiRepository.getTableStudentiByMbiemri(mbiemri);
            }
            else if(id.equals("")){
                studentiData = StudentiRepository.getTableStudentiByEmri(emri);
                studentiData.addAll(StudentiRepository.getTableStudentiByMbiemri(mbiemri));
            }
            else if(emri.equals("")){
                studentiData = StudentiRepository.getTableStudentiById(Integer.parseInt(id));
                studentiData.addAll(StudentiRepository.getTableStudentiByMbiemri(mbiemri));
            }
            else if(emri.equals("")){
                studentiData = StudentiRepository.getTableStudentiById(Integer.parseInt(id));
                studentiData.addAll(StudentiRepository.getTableStudentiByEmri(emri));
            }
            else{
                studentiData = StudentiRepository.getTableStudentiById(Integer.parseInt(id));
                studentiData.addAll(StudentiRepository.getTableStudentiByEmri(emri));
                studentiData.addAll(StudentiRepository.getTableStudentiByMbiemri(mbiemri));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        studentTable.setItems(studentiData);
        idFilterField.clear();
        emriFilterField.clear();
        mbiemriFilterField.clear();
    }
}
