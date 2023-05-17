package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import models.Qyteti;
import models.Shkolla;
import models.dto.CreateStudentDto;
import repository.QytetiRepository;
import repository.ShkollaRepository;
import repository.StudentiRepository;
import services.AlertUtil;
import services.DataUtil;
import services.StudentValidatorUtil;
import services.SceneUtil;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

public class RegisterViewController extends BaseController {

    @FXML
    private TextField emriTextfield;
    @FXML
    private TextField mbiemriTextfield;
    @FXML
    private RadioButton mRadioChoice;
    @FXML
    private RadioButton fRadioChoice;

    private ToggleGroup toggleGroup;
    @FXML
    private DatePicker birthdayPicker;
    @FXML
    private ChoiceBox<String> qytetiLindjesChoiceBox;
    @FXML
    private TextField emailTextfield;
    @FXML
    private ChoiceBox<String> komunaChoiceBox;
    @FXML
    private ChoiceBox<String> shkollaChoiceBox;
    @FXML
    private TextField maturaTextfield;
    @FXML
    private TextField suksesiTextfield;
    @FXML
    private TextField provimiPranuesTextfield;
    @FXML
    private ChoiceBox<String> drejtimiChoiceBox;
    @FXML
    private Button registerButton;
    @FXML
    private Button goBackButton;
    @FXML
    private Pane registerPane;
    @FXML
    private Label formaLabel;
    @FXML
    private Label emriLabel;
    @FXML
    private Label mbiemriLabel;
    @FXML
    private Label gjiniaLabel;
    @FXML
    private Label birthDateLabel;
    @FXML
    private Label birthPlaceLabel;
    @FXML
    private Label emailLabel;
    @FXML
    private Label komunaLabel;
    @FXML
    private Label highSchoolLabel;
    @FXML
    private Label maturaLabel;
    @FXML
    private Label provimiPranuesLabel;
    @FXML
    private Label drejtimiLabel;
    @FXML
    private Label suksesiShkolleMesme;

    private ArrayList<Qyteti> qytetet;
    private ArrayList<Shkolla> shkollat;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        Locale locale = Locale.getDefault();
        ResourceBundle translate = ResourceBundle.getBundle(
                "translations.content", locale
        );
        labelContent(translate);
        this.setMenuFunctions();
        toggleGroup = new ToggleGroup();
        mRadioChoice.setToggleGroup(toggleGroup);
        fRadioChoice.setToggleGroup(toggleGroup);
        this.drejtimiChoiceBox.getItems().addAll("TIK", "IKS", "EAR");

        try {
            this.qytetet = QytetiRepository.getQytetet();
            this.shkollat = ShkollaRepository.getShkollat();
            for(Qyteti qyteti: qytetet){
                this.komunaChoiceBox.getItems().add(qyteti.getEmri());
                this.qytetiLindjesChoiceBox.getItems().add(qyteti.getEmri());
                this.komunaChoiceBox.setOnAction(e -> getShkollaItems(this.komunaChoiceBox.getValue()));
            }
        } catch (SQLException e) {
            AlertUtil.alertError("Data Error", "Database Data Error", "There was an error while trying to get the data!");
        }

    }

    @FXML
    public void onKeyPressedEvent(KeyEvent e){
        if(e.getCode() == KeyCode.ENTER){
            this.registerButtonClicked();
        }
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
    public void registerButtonClicked(){
        try{
            String emri = this.emriTextfield.getText();
            String mbiemri = this.mbiemriTextfield.getText();
            char gjinia = ((RadioButton)toggleGroup.getSelectedToggle()).getText().charAt(0);

            LocalDate selectedDate = this.birthdayPicker.getValue();
            java.util.Date utilDate = Date.from(selectedDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
            java.sql.Date date = new java.sql.Date(utilDate.getTime());
            String email = this.emailTextfield.getText();

            int qyteti = DataUtil.getQytetiIdFromName(this.qytetet, this.qytetiLindjesChoiceBox.getValue());
            int komuna = DataUtil.getQytetiIdFromName(this.qytetet, this.komunaChoiceBox.getValue());
            int shkolla = DataUtil.getShkollaIdFromName(this.shkollat, this.shkollaChoiceBox.getValue());
            int matura = Integer.parseInt(this.maturaTextfield.getText());
            double suksesi = Double.parseDouble(this.suksesiTextfield.getText());
            int provimiPranues = Integer.parseInt(this.provimiPranuesTextfield.getText());
            String drejtimi = this.drejtimiChoiceBox.getValue();

            CreateStudentDto studentDto = new CreateStudentDto(emri, mbiemri, gjinia, date, email, qyteti, komuna, shkolla, suksesi, matura, provimiPranues, drejtimi);
            if(StudentValidatorUtil.validateStudentOnRegister(studentDto)){
                if(AlertUtil.alertConfirm("Confirmation", "Student Values", "Are you sure you want to proceed and register the student to the system?")) {
                    StudentiRepository.insert(studentDto);
                    AlertUtil.alertSuccess("Success!", "Inserting the student to database was successful!");
                    SceneUtil.changeScene((Stage) this.goBackButton.getScene().getWindow(), "/com/example/projektisrs/DashboardView.fxml");
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
    public void getShkollaItems(String qyteti){
        int id = DataUtil.getQytetiIdFromName(this.qytetet, qyteti);
        try{
            this.shkollat = ShkollaRepository.getShkollatByQytetiId(id);
            this.shkollaChoiceBox.getItems().clear();
            for(Shkolla shkolla: shkollat){
                this.shkollaChoiceBox.getItems().add(shkolla.getEmriShkolles());
            }
        } catch (SQLException e) {
            AlertUtil.alertError("Data Error", "Data not found!", "The data needed was not found!");
        }
    }
    @Override
    public void labelContent(ResourceBundle translate) {
        this.formaLabel.setText(translate.getString("register.formaLabel.text"));
        this.emriLabel.setText(translate.getString("register.emriLabel.text"));
        this.mbiemriLabel.setText(translate.getString("register.mbiemriLabel.text"));
        this.gjiniaLabel.setText(translate.getString("register.gjiniaLabel.text"));
        this.birthDateLabel.setText(translate.getString("register.birthDateLabel.text"));
        this.birthPlaceLabel.setText(translate.getString("register.birthPlaceLabel.text"));
        this.emailLabel.setText(translate.getString("register.emailLabel.text"));
        this.komunaLabel.setText(translate.getString("register.komunaLabel.text"));
        this.highSchoolLabel.setText(translate.getString("register.highSchoolLabel.text"));
        this.maturaLabel.setText(translate.getString("register.maturaLabel.text"));
        this.provimiPranuesLabel.setText(translate.getString("register.provimiPranuesLabel.text"));
        this.drejtimiLabel.setText(translate.getString("register.drejtimiLabel.text"));
        this.registerButton.setText(translate.getString("register.registerButton.text"));
        this.suksesiShkolleMesme.setText(translate.getString("register.HSSuccess.text"));
    }
}

