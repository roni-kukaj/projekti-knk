package services;

import javafx.scene.control.Alert;

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
}
