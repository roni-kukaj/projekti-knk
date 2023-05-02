package services;

import javafx.scene.control.Alert;
import models.dto.CreateStudentDto;

public class RegisterStudentValidatorUtil {
    public static boolean validateStudentOnRegister(CreateStudentDto studentDto){
        if(
                studentDto.getEmri().isEmpty() ||
                        studentDto.getMbiemri().isEmpty() ||
                        studentDto.getGjinia() == '\0' ||
                        studentDto.getDitelindja() == null ||
                        studentDto.getEmail().isEmpty() ||
                        studentDto.getQytetiLindjesId() == 0 ||
                        studentDto.getKomunaId() == 0 ||
                        studentDto.getShkollaId() == 0 ||
                        studentDto.getSuksesiNeShkollenMesme() == 0.0 ||
                        studentDto.getPiketTestitMatures() == 0 ||
                        studentDto.getPiketProvimitPranues() == 0 ||
                        studentDto.getDrejtimi().isEmpty()
        ){
            return false;
        }
        return true;
    }
}