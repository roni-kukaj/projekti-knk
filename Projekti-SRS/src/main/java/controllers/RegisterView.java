package controllers;

public class LoginViewController {
    @FXML
    private TextField emriTextfield;
    @FXML
    private TextField mbiemriTextfield;
    @FXML
    private RadioButton mRadioChoice;

    private RadioButton fradioChoice;

    private DatePicker birthdayPicker;

    private ChoiceBox qytetiLindjesChoiceBox;

    private TextField emailTextfield;

    private ChoiceBox komunaChoiceBox;

    private ChoiceBox shkollaChoiceBox;

    private TextField maturaTextfield;

    private TextField suksesiTextfield;

    private TextField provimiPranuesTextfield;

    private ChoiceBox drejtimiChoiceBox;

    private Button registerButton;

    @FXML
    private void loginButtonClicked(ActionEvent e){
        String emri = this.emriTextfield.getText();
        String mbiemri = this.mbiemriTextfield.getText();

        System.out.println("Username: " + username + " - Password: " + password);
    }
}