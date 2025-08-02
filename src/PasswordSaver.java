//imports
package src;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Class

public class PasswordSaver {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String FILE_PATH ="data/password.txt";

    public static void main(String[] args) {
        List<PasswordEntry> entries = new ArrayList<>();

        try {
            entries = FileManager.readPasswords(FILE_PATH);

        } catch (IOException e) {
            System.out.println("Could not load saved passwords: " + e.getMessage());
        }

        boolean running = true;
        while (running) {
            System.out.println("\n--- Password Saver---");
            System.out.println("1. View password");
            System.out.println("2. Add password");
            System.out.println("3. Exit");
            System.out.print("Select an Option");


            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    if (entries.isEmpty()) {
                        System.out.println("No saved Passwords.");
                    } else {
                        for (PasswordEntry entry : entries) {
                            System.out.println(entry);
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
                        FileManger.writePasswords(entries, FILE_PATH);
                        System.out.println("Password saved!");
                    } catch (IOException e) {
                        System.out.println("Failed to save: " + e.getMessage());
                    }
                    break;

                case "3":
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option. Try Again");
                    }
            }
        }

        scanner.close();
        System.out.println("Good Day Sir!");

    }