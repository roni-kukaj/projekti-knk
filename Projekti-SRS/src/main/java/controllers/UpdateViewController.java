package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class UpdateViewController {


    public class LoginViewController {


        private TextField emriUpdateTextfield;
        @FXML
        private TextField mbiemriUpdateTextfield;
        @FXML
        private RadioButton mRadioOption;

        private RadioButton fRadioOption;

        private DatePicker dataLindjesPicker;

        private ChoiceBox qytetiLindjesChoiceBox;

        private TextField emailTextfield;

        private ChoiceBox komunaChoiceBox;

        private ChoiceBox shkollaChoiceBox;

        private TextField testiMaturesTextfield;

        private TextField suksesiTextfield;

        private TextField provimiPranuesTextfield;

        private ChoiceBox drejtimiChoiceBox;

        private Button updateButton;

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



    }

}
