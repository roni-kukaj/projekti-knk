package models;

import java.sql.Date;

public class Studenti {
    private int studentId;
    private String emri;
    private String mbiemri;
    private char gjinia;
    private Date ditelindja;
    private String email;
    private int qytetiLindjesId;
    private int komunaId;
    private int shkollaId;
    private double suksesiNeShkollenMesme;
    private int piketTestitMatures;
    private int piketProvimitPranues;
    private String drejtimi;

    public Studenti(int studentId, String emri, String mbiemri, char gjinia, Date ditelindja, String email, int qytetiLindjesId, int komunaId, int shkollaId, double suksesiNeShkollenMesme, int piketTestitMatures, int piketProvimitPranues, String drejtimi) {

        this.studentId = studentId;
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

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {

        this.studentId = studentId;
    }

    public String getEmri() {
        return emri;
    }

    public void setEmri(String emri) {
        this.emri = emri;
    }

    public String getMbiemri() {
        return mbiemri;
    }

    public void setMbiemri(String mbiemri)
    {

        this.mbiemri = mbiemri;
    }

    public char getGjinia() {
        return gjinia;
    }

    public void setGjinia(char gjinia) {
        this.gjinia = gjinia;
    }

    public Date getDitelindja() {
        return ditelindja;
    }

    public void setDitelindja(Date ditelindja) {

        this.ditelindja = ditelindja;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getQytetiLindjesId() {
        return qytetiLindjesId;
    }

    public void setQytetiLindjesId(int qytetiLindjesId) {

        this.qytetiLindjesId = qytetiLindjesId;

    }

    public int getKomunaId() {
        return komunaId;
    }

    public void setKomunaId(int komunaId)
    {
        this.komunaId = komunaId;
    }

    public int getShkollaId() {
        return shkollaId;
    }

    public void setShkollaId(int shkollaId) {
        this.shkollaId = shkollaId;
    }

    public double
    getSuksesiNeShkollenMesme() {

        return suksesiNeShkollenMesme;
    }

    public void
    setSuksesiNeShkollenMesme(double suksesiNeShkollenMesme) {

        this.suksesiNeShkollenMesme = suksesiNeShkollenMesme;
    }

    public int getPiketTestitMatures() {
        return piketTestitMatures;
    }

    public void setPiketTestitMatures(int piketTestitMatures) {

        this.piketTestitMatures = piketTestitMatures;

    }

    public int getPiketProvimitPranues() {
        return piketProvimitPranues;
    }

    public void
    setPiketProvimitPranues(int piketProvimitPranues) {

        this.piketProvimitPranues = piketProvimitPranues;

    }

    public String getDrejtimi() {
        return drejtimi;
    }

    public void setDrejtimi(String drejtimi) {

        this.drejtimi = drejtimi;
    }
}