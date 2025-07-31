public class PasswordEntry {
    private String site;
    private String username;
    private String password;

    public PasswordEntry(String site, String username, String password) {
        this.site = site;
        this.site = username;
        this.site = password;
    }

    public String getSite () { 
        return site; 
    }

    public String getUsername () { 
        return username; 
    }

    public String getPassword () { 
        return password; 
    }

    public static PasswordEntry fromString(String line) {
        String[] parts = line.split(",", 3);
        if (parts.length == 3) {
            return new PasswordEntry(parts[0], parts[1], part[2]);
        }
        return null;
    }

    @Override
    public String toString () {
        return site + "," + username + "," + password;
    }
}