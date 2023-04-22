package controllers;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Studenti;

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
    private TableView<Studenti> studentTable;
    @FXML
    private TableColumn<Studenti, Integer> idColumn;
    @FXML
    private TableColumn<Studenti, String> emriColumn;
    @FXML
    private TableColumn<Studenti, String> mbiemriColumn;
    @FXML
    private TableColumn<Studenti, String> drejtimiColumn;

    private ObservableList<Studenti> studentiData;

    public void initialize(){
        idColumn.setCellValueFactory(new PropertyValueFactory<Studenti, Integer>("ID"));
        emriColumn.setCellValueFactory(new PropertyValueFactory<Studenti, String>("Emri"));
        mbiemriColumn.setCellValueFactory(new PropertyValueFactory<Studenti, String>("Mbiemri"));
        drejtimiColumn.setCellValueFactory(new PropertyValueFactory<Studenti, String>("Drejtimi"));

    }
}
