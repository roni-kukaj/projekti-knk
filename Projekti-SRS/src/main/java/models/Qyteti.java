package models;

public class Qyteti{
    private int qyteti_id;
    private String emri;

    public Qyteti(int qyteti_id, String emri) {
        this.qyteti_id = qyteti_id;
        this.emri = emri;
    }

    public int getQyteti_id() {
        return qyteti_id;
    }

    public void setQyteti_id(int qyteti_id) {
        this.qyteti_id = qyteti_id;
    }

    public String getEmri() {
        return emri;
    }

    public void setEmri(String emri) {
        this.emri = emri;
    }
}