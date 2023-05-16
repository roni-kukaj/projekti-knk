package models;

public class Admin {
    private int adminId;
    private String username;
    private String password;

    public Admin(int admin_id, String username, String password) {
        this.adminId = admin_id;
        this.username = username;
        this.password = password;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int admin_id) {
        this.adminId = admin_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
