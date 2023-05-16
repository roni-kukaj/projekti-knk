package models;

public class ColorSettings {
    private int id;
    private String color;
    private String logo;
    private String registerlogo;
    private String studentlogo;
    private String updatelogo;
    private String graphicslogo;
    private String settingslogo;

    public ColorSettings(int id, String color, String logo, String registerlogo, String studentlogo, String updatelogo, String graphicslogo, String settingslogo) {
        this.id = id;
        this.color = color;
        this.logo = logo;
        this.registerlogo = registerlogo;
        this.studentlogo = studentlogo;
        this.updatelogo = updatelogo;
        this.graphicslogo = graphicslogo;
        this.settingslogo = settingslogo;
    }

    public int getId() {
        return id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getRegisterlogo() {
        return registerlogo;
    }

    public void setRegisterlogo(String registerlogo) {
        this.registerlogo = registerlogo;
    }

    public String getStudentlogo() {
        return studentlogo;
    }

    public void setStudentlogo(String studentlogo) {
        this.studentlogo = studentlogo;
    }

    public String getUpdatelogo() {
        return updatelogo;
    }

    public void setUpdatelogo(String updatelogo) {
        this.updatelogo = updatelogo;
    }

    public String getGraphicslogo() {
        return graphicslogo;
    }

    public void setGraphicslogo(String graphicslogo) {
        this.graphicslogo = graphicslogo;
    }

    public String getSettingslogo() {
        return settingslogo;
    }

    public void setSettingslogo(String settingslogo) {
        this.settingslogo = settingslogo;
    }
}
