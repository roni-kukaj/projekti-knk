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
    @FXML
    private ChoiceBox drejtimiChoiceBox;
    @FXML
    private Button updateButton;
    @FXML
    private Button searchButton;
    @FXML
    private Button goBackButton;

    @FXML
    private void registerButton(ActionEvent e){
        String emri = this.emriUpdateTextfield.getText();
        String mbiemri = this.mbiemriUpdateTextfield.getText();
        String email = this.emailTextfield.getText();
        String id = this.idTextField.getText();
        String drejtimi = this.drejtimiChoiceBox.toString();
        // String provimiPranues = this.provimiPranuesTextfield.getText();


        System.out.println("Emri: " + emri + " - Mbiemri: " + mbiemri);
        System.out.println("Email: " + email);
    }
}
