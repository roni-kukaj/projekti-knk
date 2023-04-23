package models;

public class Shkolla {

    private int shkollaId;
    private String emriIShkolles;
    private int qytetiId;

    public Shkolla(int shkollaId, String emriIShkolles, int qytetiId){
        this.shkollaId=shkollaId;
        this.emriIShkolles=emriIShkolles;
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
    public void setQytetiId(){
        this.qytetiId=qytetiId;
    }

    public String getEmriIShkolles(){
        return emriIShkolles;
    }
    public void setEmriIShkolles(){
        this.emriIShkolles=emriIShkolles;
    }
}
