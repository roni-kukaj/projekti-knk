package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import services.AlertUtil;
import services.SceneUtil;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class HelpViewController extends BaseController {

    @FXML
    private Button dergoButton;
    @FXML
    private Button goBackButton;
    @FXML
    private Tab hyrjeTab;
    @FXML
    private Text hyrjeText;
    @FXML
    private Tab troubleshootingTab;
    @FXML
    private Text troubleshootingText1;
    @FXML
    private Text troubleshootingText2;
    @FXML
    private Text troubleshootingText3;
    @FXML
    private Tab FAQsTab;
    @FXML
    private Text firstQuestion;
    @FXML
    private Text secondQuestion;
    @FXML
    private Text thirdQuestion;
    @FXML
    private Text firstAns;
    @FXML
    private Text secondAns;
    @FXML
    private Text thirdAns;
    @FXML
    private Tab contactTab;


    @FXML
    public void goToDashboard() {
        try{
            SceneUtil.changeScene((Stage)this.goBackButton.getScene().getWindow(), "/com/example/projektisrs/DashboardView.fxml");
        } catch (IOException e){
            AlertUtil.alertError("System Error", "Operation Failed", "This action could not be done!");

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Locale.setDefault(new Locale("sq"));
        Locale locale = Locale.getDefault();
        ResourceBundle translate = ResourceBundle.getBundle(
                "translations.content", locale
        );
        labelContent(translate);
        this.setMenuFunctions();
    }

    @Override
    public void labelContent(ResourceBundle translate) {
        this.hyrjeTab.setText(translate.getString("help.hyrjeTab.text"));
        this.hyrjeText.setText(translate.getString("help.hyrjeText.text"));
        this.troubleshootingTab.setText(translate.getString("help.troubleshootingTab.text"));
        this.troubleshootingText1.setText(translate.getString("help.troubleshootingText1.text"));
        this.troubleshootingText2.setText(translate.getString("help.troubleshootingText2.text"));
        this.troubleshootingText3.setText(translate.getString("help.troubleshootingText3.text"));
        this.FAQsTab.setText(translate.getString("help.FAQsTab.text"));
        this.firstQuestion.setText(translate.getString("help.firstQuestion.text"));
        this.secondQuestion.setText(translate.getString("help.secondQuestion.text"));
        this.thirdQuestion.setText(translate.getString("help.thirdQuestion.text"));
        this.firstAns.setText(translate.getString("help.firstAns.text"));
        this.secondAns.setText(translate.getString("help.secondAns.text"));
        this.secondAns.setText(translate.getString("help.secondAns.text"));
        this.thirdAns.setText(translate.getString("help.thirdAns.text"));
        this.contactTab.setText(translate.getString("help.contactTab.text"));

    }
}