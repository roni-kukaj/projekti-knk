package models;

public class Qyteti{
    private int qytetiId;
    private String emri;

    public Qyteti(int qyteti_id, String emri) {
        this.qytetiId = qyteti_id;
        this.emri = emri;
    }

    public int getQytetiId() {
        return qytetiId;
    }

    public void setQytetiId(int qyteti_id) {
        this.qytetiId = qyteti_id;
    }

    public String getEmri() {
        return emri;
    }

    public void setEmri(String emri) {
        this.emri = emri;
    }
}