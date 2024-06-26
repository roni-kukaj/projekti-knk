package services;

import models.dto.CreateStudentDto;
import models.dto.UpdateStudentDto;

public class StudentValidatorUtil {
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
        if(studentDto.getEmri().length() < 2 || studentDto.getEmri().length() > 20) {
            return false;
        }
        if(studentDto.getMbiemri().length() < 2 || studentDto.getMbiemri().length() > 20){
            return false;
        }
        if(studentDto.getGjinia() != 'M' && studentDto.getGjinia() != 'F'){
            return false;
        }
        if(!studentDto.getEmail().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")){
            return false;
        }
        if(studentDto.getPiketProvimitPranues() < 0 || studentDto.getPiketProvimitPranues() > 100){
            return false;
        }
        if(studentDto.getPiketTestitMatures() < 0 || studentDto.getPiketTestitMatures() > 100){
            return false;
        }
        if(studentDto.getSuksesiNeShkollenMesme() < 1.0 || studentDto.getSuksesiNeShkollenMesme() > 5.0){
            return false;
        }

        return true;
    }
    public static boolean validateStudentOnUpdate(UpdateStudentDto updateStudentDto){
        if(
            updateStudentDto.getEmri().isEmpty() ||
            updateStudentDto.getMbiemri().isEmpty() ||
            updateStudentDto.getEmail().isEmpty() ||
            updateStudentDto.getDrejtimi().isEmpty()
        ){
            return false;
        }
        if(updateStudentDto.getEmri().length() < 2 || updateStudentDto.getEmri().length() > 20) {
            return false;
        }
        if(updateStudentDto.getMbiemri().length() < 2 || updateStudentDto.getMbiemri().length() > 20){
            return false;
        }
        if(!updateStudentDto.getEmail().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")){
            return false;
        }
        return true;
    }
}