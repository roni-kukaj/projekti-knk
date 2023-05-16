import controllers.BaseController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import models.dto.UpdateStudentDto;
import repository.StudentiRepository;
import services.AlertUtil;
import services.StudentValidatorUtil;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Locale;
import java.util.ResourceBundle;
public class UpdateViewController extends BaseController {
    @FXML
    private TextField emriUpdateTextfield;
    @FXML
    private TextField mbiemriUpdateTextfield;
    @FXML
    private TextField emailTextfield;
    @FXML
    private TextField idTextField;
    @FXML
    private ChoiceBox<String> drejtimiChoiceBox;
    @FXML
    private Button updateButton;
    @FXML
    private Button searchButton;
    @FXML
    private Button goBackButton;
    @FXML
    private Label searchWithID;
    @FXML
    private Label updateForm;
    @FXML
    private Label updateEmri;
    @FXML
    private Label updateMbiemri;
    @FXML
    private Label updateEmail;
    @FXML
    private Label updateDrejtimi;

    private int id;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        Locale locale = Locale.getDefault();
        ResourceBundle translate = ResourceBundle.getBundle(
                "translations.content", locale
        );
        labelContent(translate);
        this.setMenuFunctions();
        this.drejtimiChoiceBox.getItems().addAll("EAR", "TIK", "IKS");
        this.id = 0;
    }

    private void fillForm(UpdateStudentDto updateStudentDto){
        this.emriUpdateTextfield.setText(updateStudentDto.getEmri());
        this.mbiemriUpdateTextfield.setText(updateStudentDto.getMbiemri());
        this.emailTextfield.setText(updateStudentDto.getEmail());
        this.drejtimiChoiceBox.setValue(updateStudentDto.getDrejtimi());
    }


    @FXML
    public void updateButtonClicked(){
        try {
            String emri = this.emriUpdateTextfield.getText();
            String mbiemri = this.mbiemriUpdateTextfield.getText();
            String email = this.emailTextfield.getText();
            String drejtimi = this.drejtimiChoiceBox.getValue();
            if(!StudentValidatorUtil.validateStudentOnUpdate(new UpdateStudentDto(this.id, emri, mbiemri, email, drejtimi))){
                AlertUtil.alertError("Input Error", "Incorrect Input", "The id field should not be empty!");
                return;
            }
            if(this.id == 0){
                AlertUtil.alertError("System Error", "Unexpected Error", "Something went wrong!");
                return;
            }
            if(StudentiRepository.update(new UpdateStudentDto(this.id, emri, mbiemri, email, drejtimi))){
                AlertUtil.alertSuccess("Update Successful", "The student information was updated!");
                this.searchButtonClicked();
                return;
            }
            else{
                AlertUtil.alertError("Update Error", "Student Update Error", "Student could not me updated!");
                return;
            }

        }
        catch(Exception e1){
            AlertUtil.alertError("Input Error", "Input Error", e1.getMessage());
        }
    }