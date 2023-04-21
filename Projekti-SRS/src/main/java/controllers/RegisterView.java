package controllers;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoginViewController {
    @FXML
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
        String birthdate = this.birthdayPicker.getText();
        String choiceBox = this.qytetiLindjesChoiceBox.getText();
        String email = this.emailTextfield.getText();
        String komuna = this.komunaChoiceBox.getText();
        String shkolla = this.shkollaChoiceBox.getText();
        String matura = this.maturaTextfield.getText();
        String suksesi = this.suksesiTextfield.getText();
        String provimiPranues = this.provimiPranuesTextfield.getText();
        String drejtimi = this.drejtimiChoiceBox.getText();
        String provimiPranues = this.provimiPranuesTextfield.getText();

    }
}