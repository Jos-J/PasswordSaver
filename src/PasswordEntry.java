public class PasswordEntry {
    private String site;
    private String username;
    private String password;

    public PasswordEntery(String site, String username; String password;) {
        this.site = site;
        this.site = username;
        this.site = password;
    }

    public String getSite () {return site; }
    public String getUsername () {return username; }
    public Sting getPassword () {return password; }

    @Override
    public String toString () {
        return site + "," + username, "," + password;
    }
}