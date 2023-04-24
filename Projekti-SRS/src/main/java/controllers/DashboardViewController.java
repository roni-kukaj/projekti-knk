package controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import services.SceneUtil;

import java.io.IOException;


public class DashboardViewController {

    private Button registerStudentButton;
    private Button studentListButton;
    private Button updateStudentButton;
    private Button graphicsButton;
    private Button settingsButton;


    public void registerClicked(ActionEvent e)throws IOException{
        {
            try{
                SceneUtil.changeScene((Stage)this.registerStudentButton.getScene().getWindow(), "/com/example/projektisrs/RegisterView.fxml");
            } catch(IOException ioe){
                // TO DO
            }
        }
    }

    public void studentClicked(ActionEvent e)throws IOException{
        {
            try{
                SceneUtil.changeScene((Stage)this.studentListButton.getScene().getWindow(), "/com/example/projektisrs/StudentsView.fxml");
            } catch(IOException ioe){
                // TO DO
            }
        }
    }


    public void updateClicked(ActionEvent e)throws IOException{
        {
            try{
                SceneUtil.changeScene((Stage)this.updateStudentButton.getScene().getWindow(), "/com/example/projektisrs/UpdateView.fxml");
            } catch(IOException ioe){
                // TO DO
            }
        }
    }

    public void graphicsClicked(ActionEvent e)throws IOException{
        {
            try{
                SceneUtil.changeScene((Stage)this.graphicsButton.getScene().getWindow(), "/com/example/projektisrs/GraphicsView.fxml");
            } catch(IOException ioe){
                // TO DO
            }
        }
    }


    public void settingsClicked(ActionEvent e)throws IOException{
        {
            try{
                SceneUtil.changeScene((Stage)this.settingsButton.getScene().getWindow(), "/com/example/projektisrs/SettingsView.fxml");
            } catch(IOException ioe){
                // TO DO
            }
        }
    }


}


