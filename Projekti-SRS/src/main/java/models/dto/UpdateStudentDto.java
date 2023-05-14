package models.dto;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import services.StudentValidatorUtil;

public class UpdateStudentDto {

    private int id;
    private String emri;
    private String mbiemri;
    private String email;
    private String drejtimi;

    public UpdateStudentDto(int id, String emri, String mbiemri, String email, String drejtimi){
        this.id = id;
        this.emri = emri;
        this.mbiemri = mbiemri;
        this.email = email;
        this.drejtimi = drejtimi;
    }

    public String getEmri(){
        return emri;
    }

    public String getMbiemri(){
        return mbiemri;
    }
    public String getEmail(){
        return email;
    }
    public int getId(){
        return id;
    }
    public String getDrejtimi(){
        return drejtimi;
    }
}
