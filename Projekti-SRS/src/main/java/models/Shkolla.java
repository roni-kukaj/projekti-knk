package models;

public class Shkolla {

    private int shkollaId;
    private String emriShkolles;
    private int qytetiId;

    public Shkolla(int shkollaId, String emriShkolles, int qytetiId){
        this.shkollaId=shkollaId;
        this.emriShkolles=emriShkolles;
        this.qytetiId=qytetiId;
    }

    public int getShkollaId(){
        return shkollaId;
    }

    public void setShkollaId(){
        this.shkollaId=shkollaId;
    }

    public int getQytetiId(){
        return qytetiId;
    }
    public void setQytetiId(int qytetiId){
        this.qytetiId=qytetiId;
    }

    public String getEmriShkolles(){
        return emriShkolles;
    }
    public void setEmriShkolles(String emriShkolles){
        this.emriShkolles=emriShkolles;
    }
}
