package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import models.Studenti;
import models.TableStudenti;
import repository.QytetiRepository;
import repository.ShkollaRepository;
import repository.StudentiRepository;
import services.SceneUtil;

import java.io.IOException;
import java.sql.SQLException;

public class StudentiIndividualViewController {
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

    private Studenti studenti;


    public void initialize() {
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

        }
    }

    public void initData(int studentId){
        try{
            this.studenti = StudentiRepository.getStudentiById(studentId);
            initialize();
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
    }

    public void goBack(){
        try {
            SceneUtil.changeScene((Stage) this.goBackButton.getScene().getWindow(), "/com/example/projektisrs/StudentsView.fxml");
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
    }
}
