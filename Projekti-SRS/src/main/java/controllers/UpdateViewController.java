package controllers;

import controllers.BaseController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import models.dto.UpdateStudentDto;
import repository.StudentiRepository;
import services.AlertUtil;
import services.SceneUtil;
import services.StudentValidatorUtil;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
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
    @FXML
    public void searchButtonClicked(){
        if(this.idTextField.getText().isEmpty()){
            AlertUtil.alertError("Input Error", "Empty Field", "The id field should not be empty!");
            return;
        }
        try{
            this.id = Integer.parseInt(this.idTextField.getText());
            UpdateStudentDto updateStudentDto = StudentiRepository.getUpdateStudentDtoFromId(id);
            if(updateStudentDto != null)
                this.fillForm(updateStudentDto);
            else
                throw new Exception("Student was not found!");
        }   catch (NumberFormatException ne){
            AlertUtil.alertError("Input Error", "Incorrect Input", "Check if the format you have entered is incorrect!");
        }
        catch (SQLException se){
            AlertUtil.alertError("Data Error", "Data not found", "The id you've entered does not exist in the system!");
        }catch (Exception ee){
            AlertUtil.alertError("Data Error", "Data not found", ee.getMessage());
        }
    }
    @FXML
    public void onKeyPressedEvent(KeyEvent e){
        if(e.getCode() == KeyCode.ENTER){
            this.updateButtonClicked();
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
    public void initData(int studentId){
        this.id = studentId;
        this.idTextField.setText(String.valueOf(id));
        this.searchButtonClicked();
    }
    @Override
    public void labelContent(ResourceBundle translate) {
        this.searchWithID.setText(translate.getString("update.searchWithID"));
        this.searchButton.setText(translate.getString("update.searchButton"));
        this.updateForm.setText(translate.getString("update.updateForm.text"));
        this.updateEmri.setText(translate.getString("update.updateEmri.text"));
        this.updateMbiemri.setText(translate.getString("update.updateMbiemri.text"));
        this.updateEmail.setText(translate.getString("update.updateEmail.text"));
        this.updateDrejtimi.setText(translate.getString("update.updateDrejtimi.text"));
        this.updateButton.setText(translate.getString("update.updateButton"));
    }
}