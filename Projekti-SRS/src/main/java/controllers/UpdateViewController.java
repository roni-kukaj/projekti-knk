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
    private TextField emailTextfield;
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
        String email = this.emailTextfield.getText();
        String drejtimi = this.drejtimiChoiceBox.toString();
        // String provimiPranues = this.provimiPranuesTextfield.getText();


        System.out.println("Emri: " + emri + " - Mbiemri: " + mbiemri);
        System.out.println("Email: " + email);
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