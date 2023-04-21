package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class LogInViewController {
    private TextField emriTextfield;
    @FXML
    private TextField mbiemriTextfield;
    @FXML
    private RadioButton mRadioChoice;

    private RadioButton fradioChoice;

    private DatePicker birthdayPicker;

    private ChoiceBox qytetiLindjesChoiceBox;

    private TextField emailTextfield;

    private ChoiceBox komunaChoiceBox;

    private ChoiceBox shkollaChoiceBox;

    private TextField maturaTextfield;

    private TextField suksesiTextfield;

    private TextField provimiPranuesTextfield;

    private ChoiceBox drejtimiChoiceBox;

    private Button registerButton;

    @FXML
    private void registerButton(ActionEvent e){
        String emri = this.emriTextfield.getText();
        String mbiemri = this.mbiemriTextfield.getText();
        String Mchoice = this.mRadioChoice.getText();
        String Fchoice = this.fradioChoice.getText();
        String birthdate = this.birthdayPicker.toString();
        String choiceBox = this.qytetiLindjesChoiceBox.toString();
        String email = this.emailTextfield.getText();
        String komuna = this.komunaChoiceBox.toString();
        String shkolla = this.shkollaChoiceBox.toString();
        String matura = this.maturaTextfield.getText();
        String suksesi = this.suksesiTextfield.getText();
        String provimiPranues = this.provimiPranuesTextfield.getText();
        String drejtimi = this.drejtimiChoiceBox.toString();
        // String provimiPranues = this.provimiPranuesTextfield.getText();


        System.out.println("Emri: " + emri + " - Mbiemri: " + mbiemri);
        System.out.println("Data e Lindjes: " + birthdate  + " - Email: " + email);
        System.out.println("Testi i Matures: " + matura  + " - Suksesi ne SHM: " + suksesi + "Provimi pranues" + provimiPranues);
    }
}