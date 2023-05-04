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
}
