package controllers;

import javafx.event.ActionEvent;
import javafx.scene.image.ImageView;

public class DashboardViewController {

    private ImageView registerImageView;
    private ImageView stulistImageView;
    private ImageView updateImageView;
    private ImageView graphicsImageView;
    private ImageView settingImageView;


    public void Clicked(ActionEvent e){

        if (e.getSource() == registerImageView) {

            System.out.println("Register image view clicked.");
        } else if (e.getSource() == stulistImageView) {
            System.out.println("Student list image view clicked.");
        } else if (e.getSource() == updateImageView) {
            System.out.println("Update image view clicked.");
        } else if (e.getSource() == graphicsImageView) {
            System.out.println("Graphics image view clicked.");
        } else if (e.getSource() == settingImageView) {
            System.out.println("Settings image view clicked.");
        }
    }
    }

