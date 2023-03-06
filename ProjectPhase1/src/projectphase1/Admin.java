package projectphase1;


public class Admin extends User {
    public Admin(String usernname, String password) {
        this.password = password;
        this.username = usernname;
        this.role = "admin";
    }

}
