package session;

// testing out, not to use yet

import models.Admin;

public class AdminSession {
    private Admin admin;
    private boolean loggedIn;

    public AdminSession(Admin admin, boolean loggedIn){
        this.admin = admin;
        this.loggedIn = loggedIn;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
}
