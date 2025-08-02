// package
package src;

// imports
import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Class//

public class FileManager {
    private static final String FILE_PATH = "data/password.txt";

    public static List<PasswordEntry> loadEntries() {
        List<PasswordEntry> entries = new ArrayList<>();
        File file = new File(FILE_PATH);

        if (!file.exists()) {
            new File("data").mkdirs(); // make sure data exists
            return entries;
        }

        try (BufferedReader reader = BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                PasswordEntry entry = PasswordEntry.fromString(line);
                if (entry != null) {
                    entries.add(entry);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
        return entries;
    }

    public static void saveEntries(List<PasswordEntry> entries) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (PasswordEntry entry : entries) {
                writer.write(entry.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing to file:" + e.getMessage());
        }
    }

}