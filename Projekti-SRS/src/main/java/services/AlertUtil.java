package services;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class AlertUtil {
    public static void alertError(String alertTitle, String headerText, String contentText){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(alertTitle);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        alert.showAndWait();
    }
    public static void alertSuccess(String alertTitle, String headerText){
        Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
        successAlert.setTitle(alertTitle);
        successAlert.setHeaderText(headerText);
        successAlert.setContentText(null);
        successAlert.showAndWait();
    }
    public static boolean alertConfirm(String alertTitle, String headerText, String contentText){
        Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationAlert.setTitle(alertTitle);
        confirmationAlert.setHeaderText(headerText);
        confirmationAlert.setContentText(contentText);
        confirmationAlert.getButtonTypes().setAll(ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> result = confirmationAlert.showAndWait();

        if(result.isPresent() && result.get() == ButtonType.YES){
            return true;
        }
        else{
            return false;
        }
    }
}
