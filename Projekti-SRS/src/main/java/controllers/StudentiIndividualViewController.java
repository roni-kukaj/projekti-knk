package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import models.Studenti;
import models.TableStudenti;
import repository.QytetiRepository;
import repository.ShkollaRepository;
import repository.StudentiRepository;
import services.AlertUtil;
import services.FileUtil;
import services.SceneUtil;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class StudentiIndividualViewController extends BaseController {
    @FXML
    private Label idLabel;
    @FXML
    private Label emriLabel;
    @FXML
    private Label mbiemriLabel;
    @FXML
    private Label gjiniaLabel;
    @FXML
    private Label datelindjaLabel;
    @FXML
    private Label emailLabel;
    @FXML
    private Label qytetiLindjesLabel;
    @FXML
    private Label komunaLabel;
    @FXML
    private Label shkollaLabel;
    @FXML
    private Label suksesiLabel;
    @FXML
    private Label piketMaturesLabel;
    @FXML
    private Label provimiPranuesLabel;
    @FXML
    private Label drejtimiLabel;
    @FXML
    private Button goBackButton;

    @FXML
    private Button updateInfoButton;
    @FXML
    private Button deleteStudentButton;

    @FXML
    private Button printAsPDFButton;

    private Studenti studenti;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.setMenuFunctions();
        fillData();
    }

    @FXML
    public void deleteStudentButtonClicked(ActionEvent e){
        try{
            if(studenti != null){
                if(AlertUtil.alertConfirm("Confirmation", "Delete Student", "Are you sure you want to proceed and delete the student from the system?")) {
                    if(StudentiRepository.delete(studenti.getStudentId())) {
                        AlertUtil.alertSuccess("Success!", "Deleting the student from the system was successful!");
                        SceneUtil.changeScene((Stage) this.goBackButton.getScene().getWindow(), "/com/example/projektisrs/StudentsView.fxml");
                    }
                    else{
                        throw new Exception("The action could not be completed!");
                    }
                }
            }
            else{
                throw new Exception("No data to delete");
            }
        }
        catch (Exception ee){
            AlertUtil.alertError("Data Error", "Data Error", ee.getMessage());
        }
    }
    public void fillData(){
        try {
            if (studenti == null) {
                return;
            }
            this.idLabel.setText("" + this.studenti.getStudentId());
            this.emriLabel.setText(this.studenti.getEmri());
            this.mbiemriLabel.setText(this.studenti.getMbiemri());
            this.gjiniaLabel.setText("" + this.studenti.getGjinia());
            this.datelindjaLabel.setText(this.studenti.getDitelindja().toString());
            this.emailLabel.setText("" + this.studenti.getEmail());
            this.qytetiLindjesLabel.setText("" + QytetiRepository.getQytetiById(this.studenti.getQytetiLindjesId()).getEmri());
            this.komunaLabel.setText("" + QytetiRepository.getQytetiById(this.studenti.getKomunaId()).getEmri());
            this.shkollaLabel.setText("" + ShkollaRepository.getShkollaById(this.studenti.getShkollaId()).getEmriShkolles());
            this.suksesiLabel.setText("" + this.studenti.getSuksesiNeShkollenMesme());
            this.piketMaturesLabel.setText("" + this.studenti.getPiketTestitMatures());
            this.provimiPranuesLabel.setText("" + this.studenti.getPiketProvimitPranues());
            this.drejtimiLabel.setText(this.studenti.getDrejtimi());
        }
        catch(SQLException sqlException){
            AlertUtil.alertError("Data Error", "Data not found!", "We're sorry, but the data you requested was not found!");
            return ;
        }
    }

    public void initData(int studentId){
        try{
            this.studenti = StudentiRepository.getStudentiById(studentId);
            fillData();
        } catch (SQLException e) {
            AlertUtil.alertError("Data Error", "Data not found", "We're sorry  but the data you requested could no be found!");
            return;
        }
    }

    public void goBack(){
        try {
            SceneUtil.changeScene((Stage) this.goBackButton.getScene().getWindow(), "/com/example/projektisrs/StudentsView.fxml");
        } catch (IOException e) {
            AlertUtil.alertError("System Error", "System Error", "We're sorry, but this action could not be completed!");
            return;
        }
    }

    @FXML
    public void printAsPDFButtonClicked() {
        try{
            String directory = FileUtil.getDirectoryFromUser((Stage) this.printAsPDFButton.getScene().getWindow());
            FileUtil.writeStudentInfoOnPDF(this.studenti, directory);
        }
        catch (IOException e){
            AlertUtil.alertError("File Error", "File could not be created!", "Please try again later!");
        } catch (SQLException e) {
            AlertUtil.alertError("Data Error", "Data not found", "We're sorry  but the data you requested could no be found!");
        }
    }

    @FXML
    public void updateInfoButtonClicked()  {
        try{
            if(this.studenti != null){
                SceneUtil.changeSceneWithIdParameterForUpdate((Stage)this.deleteStudentButton.getScene().getWindow(), "/com/example/projektisrs/UpdateView.fxml", this.studenti.getStudentId());
            }
        }
        catch (IOException ie){
            AlertUtil.alertError("System Error", "System Error", "We're sorry, but this action could not be completed!");
        }
    }
}
