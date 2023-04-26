package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class RegisterViewController {


    public class LoginViewController {

        @FXML
        private TextField emriTextfield;
        @FXML
        private TextField mbiemriTextfield;
        @FXML
        private RadioButton mRadioChoice;
        @FXML
        private RadioButton fradioChoice;
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

        @FXML
        private void registerButton(ActionEvent e){
            String emri = this.emriTextfield.getText();
            String mbiemri = this.mbiemriTextfield.getText();
            String Mchoice = this.mRadioChoice.getText();
            String Fchoice = this.fradioChoice.getText();
            String birthdate = this.birthdayPicker.toString();
            String choiceBox = this.qytetiLindjesChoiceBox.toString();
            String email = this.emailTextfield.getText();
            String komuna = this.komunaChoiceBox.toString();
            String shkolla = this.shkollaChoiceBox.toString();
            String matura = this.maturaTextfield.getText();
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

}
