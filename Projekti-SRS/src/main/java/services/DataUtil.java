package services;

import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import models.Qyteti;
import models.Shkolla;
import repository.StudentiRepository;

import java.sql.SQLException;
import java.util.ArrayList;

public class DataUtil {
    public static ArrayList<PieChart.Data> getData(String criteria) throws SQLException{
        ArrayList<PieChart.Data> data;
        if(criteria.equals("Drejtim - Studentë")){
            data = StudentiRepository.getDrejtimiStudentetData();
        }
        else if(criteria.equals("Drejtim - Pikë Provim Pranues")){
            data = StudentiRepository.getDrejtimiPiketData();
        }
        else if(criteria.equals("Qytet - Studentë")){
            data = StudentiRepository.getQytetiStudentetData();
        }
        else{
            return null;
        }
        return data;
    }
    public static int getShkollaIdFromName(ArrayList<Shkolla> shkollat, String name){
        for(Shkolla shkolla: shkollat){
            if(shkolla.getEmriShkolles().equals(name)){
                return shkolla.getShkollaId();
            }
        }
        return 0;
    }
    public static int getQytetiIdFromName(ArrayList<Qyteti> qytetet, String name){
        for(Qyteti qyteti: qytetet){
            if(qyteti.getEmri().equals(name)){
                return qyteti.getQytetiId();
            }
        }
        return 0;
    }
}
