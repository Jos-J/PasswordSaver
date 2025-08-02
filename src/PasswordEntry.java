public class PasswordEntry {
    private String site;
    private String username;
    private String password;

    public PasswordEntry(String site, String username, String password) {
        this.site = site;
        this.username = username;
        this.password = password;
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

   // Converts a CSV line into a PasswordEntry, decrypting the password
    public static PasswordEntry fromString(String line) {
        String[] parts = line.split(",", 3);
        if (parts.length == 3) {
            String decryptedPassword = EncryptionUtils.decrypt(parts[2]);
            return new PasswordEntry(parts[0], parts[1], decryptedPassword);
        }
        return null;
    }

    // Converts the entry into a CSV line, encrypting the password
    @Override
    public String toString() {
        String encryptedPassword = EncryptionUtils.encrypt(password);
        return site + "," + username + "," + encryptedPassword;
    }
}