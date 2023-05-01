package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import services.SceneUtil;

import java.io.IOException;

public class UpdateViewController {
    @FXML
    private TextField emriUpdateTextfield;
    @FXML
    private TextField mbiemriUpdateTextfield;
    @FXML
    private RadioButton mRadioOption;
    @FXML
    private RadioButton fRadioOption;
    @FXML
    private DatePicker dataLindjesPicker;
    @FXML
    private ChoiceBox qytetiLindjesChoiceBox;
    @FXML
    private TextField emailTextfield;
    @FXML
    private ChoiceBox komunaChoiceBox;
    @FXML
    private ChoiceBox shkollaChoiceBox;
    @FXML
    private TextField testiMaturesTextfield;
    @FXML
    private TextField suksesiTextfield;
    @FXML
    private TextField provimiPranuesTextfield;
    @FXML
    private ChoiceBox drejtimiChoiceBox;
    @FXML
    private Button updateButton;
    @FXML
    private Button goBackButton;

    @FXML
    private void registerButton(ActionEvent e){
        String emri = this.emriUpdateTextfield.getText();
        String mbiemri = this.mbiemriUpdateTextfield.getText();
        String Mchoice = this.mRadioOption.getText();
        String Fchoice = this.fRadioOption.getText();
        String birthdate = this.dataLindjesPicker.toString();
        String choiceBox = this.qytetiLindjesChoiceBox.toString();
        String email = this.emailTextfield.getText();
        String komuna = this.komunaChoiceBox.toString();
        String shkolla = this.shkollaChoiceBox.toString();
        String matura = this.testiMaturesTextfield.getText();
        String suksesi = this.suksesiTextfield.getText();
        String provimiPranues = this.provimiPranuesTextfield.getText();
        String drejtimi = this.drejtimiChoiceBox.toString();
        // String provimiPranues = this.provimiPranuesTextfield.getText();


        System.out.println("Emri: " + emri + " - Mbiemri: " + mbiemri);
        System.out.println("Data e Lindjes: " + birthdate  + " - Email: " + email);
        System.out.println("Testi i Matures: " + matura  + " - Suksesi ne SHM: " + suksesi + "Provimi pranues" + provimiPranues);
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