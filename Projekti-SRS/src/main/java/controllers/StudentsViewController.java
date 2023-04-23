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
            studentiData = StudentiRepository.getStudentsForTable();
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        studentTable.setItems(studentiData);
    }
}
