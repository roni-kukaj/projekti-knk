package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import models.dto.CreateStudentDto;
import repository.StudentiRepository;
import services.AlertUtil;
import services.RegisterStudentValidatorUtil;
import services.SceneUtil;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ResourceBundle;

public class RegisterViewController implements Initializable {

    @FXML
    private TextField emriTextfield;
    @FXML
    private TextField mbiemriTextfield;
    @FXML
    private RadioButton mRadioChoice;
    @FXML
    private RadioButton fradioChoice;

    private ToggleGroup toggleGroup;
    @FXML
    private DatePicker birthdayPicker;
    @FXML
    private ChoiceBox qytetiLindjesChoiceBox;
    @FXML
    private TextField emailTextfield;
    @FXML
    private ChoiceBox komunaChoiceBox;
    @FXML
    private ChoiceBox shkollaChoiceBox;
    @FXML
    private TextField maturaTextfield;
    @FXML
    private TextField suksesiTextfield;
    @FXML
    private TextField provimiPranuesTextfield;
    @FXML
    private ChoiceBox drejtimiChoiceBox;
    @FXML
    private Button registerButton;
    @FXML
    private Button goBackButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        toggleGroup = new ToggleGroup();
        mRadioChoice.setToggleGroup(toggleGroup);
        fradioChoice.setToggleGroup(toggleGroup);
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

    @FXML
    public void registerButtonClicked(ActionEvent e){
        try{
            String emri = this.emriTextfield.getText();
            String mbiemri = this.mbiemriTextfield.getText();
            char gjinia = ((RadioButton)toggleGroup.getSelectedToggle()).getText().charAt(0);

            LocalDate selectedDate = this.birthdayPicker.getValue();
            Instant instant = Instant.from(selectedDate.atStartOfDay(ZoneId.systemDefault()));
            Date date = (Date) Date.from(instant);
            String choiceBox = this.qytetiLindjesChoiceBox.toString();
            String email = this.emailTextfield.getText();

            int qyteti = Integer.parseInt((String) this.qytetiLindjesChoiceBox.getValue());
            int komuna = Integer.parseInt((String) this.komunaChoiceBox.getValue());
            int shkolla = Integer.parseInt((String) this.shkollaChoiceBox.toString());
            int matura = Integer.parseInt(this.maturaTextfield.getText());
            double suksesi = Double.parseDouble(this.suksesiTextfield.getText());
            int provimiPranues = Integer.parseInt(this.provimiPranuesTextfield.getText());
            String drejtimi = this.drejtimiChoiceBox.toString();
            CreateStudentDto studentDto = new CreateStudentDto(emri, mbiemri, gjinia, date, email, qyteti, komuna, shkolla, suksesi, matura, provimiPranues, drejtimi);
            if(RegisterStudentValidatorUtil.validateStudentOnRegister(studentDto)){
                if(StudentiRepository.insert(studentDto)){
                    AlertUtil.alertSuccess("Success!", "Inserting the student to database was successful!");
                    SceneUtil.changeScene((Stage)this.goBackButton.getScene().getWindow(), "/com/example/projektisrs/DashboardView.fxml");
                }
                else{
                    AlertUtil.alertError("Database Error", "Data could not be inserted in the database!", "Please check the data format again!");
                }
            }
            else {
                AlertUtil.alertError("Registration Error", "ALl fields are required!", "Please fill all of the fields before proceeding!");
            }
        }
        catch(Exception exc){
            AlertUtil.alertError("Input Error", "Wrong input!", "Please check that all of the fields have the right type of data!");
        }
    }
}