package models.dto;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class UpdateStudentDto {

    private String emri;

    private String mbiemri;

    private String email;

    private int id;

    private String drejtimi;

    public UpdateStudentDto(String emri, String mbiemri, String email, int id, String drejtimi){
            this.emri = emri;
            this.mbiemri = mbiemri;
            this.email = email;
            this.id = id;
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
