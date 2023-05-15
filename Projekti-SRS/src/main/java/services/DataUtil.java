package services;

import javafx.scene.chart.XYChart;
import repository.StudentiRepository;

import java.sql.SQLException;
import java.util.ArrayList;

public class DataUtil {
    public static XYChart.Series<String, Number> getChartData(String criteria) throws SQLException {
        XYChart.Series<String, Number> data = new XYChart.Series<>();
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
}
