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
    private TextField emailTextfield;
    @FXML
    private TextField idTextField;
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