package models.dto;

import java.sql.Date;

public class CreateStudentDto {
    private String emri;
    private String mbiemri;
    private char gjinia;
    private java.sql.Date ditelindja;
    private String email;
    private int qytetiLindjesId;
    private int komunaId;
    private int shkollaId;
    private double suksesiNeShkollenMesme;
    private int piketTestitMatures;
    private int piketProvimitPranues;
    private String drejtimi;

    public CreateStudentDto(String emri, String mbiemri, char gjinia, Date ditelindja, String email, int qytetiLindjesId, int komunaId, int shkollaId, double suksesiNeShkollenMesme, int piketTestitMatures, int piketProvimitPranues, String drejtimi) {
        this.emri = emri;
        this.mbiemri = mbiemri;
        this.gjinia = gjinia;
        this.ditelindja = ditelindja;
        this.email = email;
        this.qytetiLindjesId =  qytetiLindjesId;
        this.komunaId = komunaId;
        this.shkollaId = shkollaId;
        this.suksesiNeShkollenMesme =  suksesiNeShkollenMesme;
        this.piketTestitMatures = piketTestitMatures;
        this.piketProvimitPranues = piketProvimitPranues;
        this.drejtimi = drejtimi;
    }

    public String getEmri() {
        return emri;
    }
    public String getMbiemri() {
        return mbiemri;
    }
    public char getGjinia() {
        return gjinia;
    }
    public java.sql.Date getDitelindja() {
        return ditelindja;
    }
    public String getEmail() {
        return email;
    }
    public int getQytetiLindjesId() {
        return qytetiLindjesId;
    }
    public int getKomunaId() {
        return komunaId;
    }
    public int getShkollaId() {
        return shkollaId;
    }
    public double getSuksesiNeShkollenMesme() {return suksesiNeShkollenMesme;}
    public int getPiketTestitMatures() {
        return piketTestitMatures;
    }
    public int getPiketProvimitPranues() {
        return piketProvimitPranues;
    }
    public String getDrejtimi() {
        return drejtimi;
    }
}