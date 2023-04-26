package models;

public class TableStudenti {
    private int id;
    private String emri;
    private String mbiemri;
    private String drejtimi;

    public TableStudenti(int id, String emri, String mbiemri, String drejtimi) {
        this.id = id;
        this.emri = emri;
        this.mbiemri = mbiemri;
        this.drejtimi = drejtimi;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmri() {
        return this.emri;
    }

    public void setEmri(String emri) {
        this.emri = emri;
    }

    public String getMbiemri() {
        return this.mbiemri;
    }

    public void setMbiemri(String mbiemri) {
        this.mbiemri = mbiemri;
    }

    public String getDrejtimi() {
        return drejtimi;
    }

    public void setDrejtimi(String drejtimi) {
        this.drejtimi = drejtimi;
    }
}
