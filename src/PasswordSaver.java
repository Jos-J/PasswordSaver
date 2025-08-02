package src;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

public class PasswordSaver {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String FILE_PATH = "data/passwords.txt";

    public static void main(String[] args) {
        // Uncomment this to run test instead of full program
        // runTest();
        runApp();
    }

    // The main app logic
    public static void runApp() {
        List<PasswordEntry> entries = new ArrayList<>();

        try {
            entries = FileManager.loadEntries();
        } catch (Exception e) {
            System.out.println("Could not load saved passwords: " + e.getMessage());
        }

        boolean running = true;
        while (running) {
            System.out.println("\n--- Password Saver ---");
            System.out.println("1. View passwords");
            System.out.println("2. Add password");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    if (entries.isEmpty()) {
                        System.out.println("No saved passwords.");
                    } else {
                        for (PasswordEntry entry : entries) {
                            System.out.println("Site: " + entry.getSite());
                            System.out.println("Username: " + entry.getUsername());
                            System.out.println("Password: " + entry.getPassword());
                            System.out.println("------------------------");
                        }
                    }
                    break;

                case "2":
                    System.out.print("Enter site name: ");
                    String site = scanner.nextLine();
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();

                    PasswordEntry newEntry = new PasswordEntry(site, username, password);
                    entries.add(newEntry);

                    try {
                        FileManager.saveEntries(entries);
                        System.out.println("✅ Password saved!");
                    } catch (IOException e) {
                        System.out.println("❌ Failed to save: " + e.getMessage());
                    }
                    break;

                case "3":
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close();
        System.out.println("Good day, sir!");
    }

    // 🔍 Test method (for development)
    public static void runTest() {
        System.out.println("Running test...");

        // Create a test entry
        PasswordEntry testEntry = new PasswordEntry("example.com", "testuser", "test123");

        // Encrypt & print it
        System.out.println("Original password: " + testEntry.getPassword());
        String encrypted = EncryptionUtils.encrypt(testEntry.getPassword());
        System.out.println("Encrypted: " + encrypted);
        String decrypted = EncryptionUtils.decrypt(encrypted);
        System.out.println("Decrypted: " + decrypted);

        // Save to file
        List<PasswordEntry> testList = new ArrayList<>();
        testList.add(testEntry);
        FileManager.saveEntries(testList);

        // Load and print
        List<PasswordEntry> loaded = FileManager.loadEntries();
        for (PasswordEntry entry : loaded) {
            System.out.println("Loaded entry → " + entry.getSite() + ", " + entry.getUsername() + ", " + entry.getPassword());
        }

        System.out.println("Test complete.");
    }
}
