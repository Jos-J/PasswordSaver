# 🔐 Password Saver (Java)

A simple command-line **Password Saver** application built with Java. This project allows users to securely store and retrieve saved passwords for different accounts.

---

## ✨ Features

- Add and store passwords locally
- View saved passwords
- Delete individual entries
- Optional encryption for secure storage
- Simple file-based storage using `passwords.txt`

---

## 📂 File Structure

```
PasswordSaver-Java/
├── src/
│   ├── PasswordSaver.java          # Main class with menu & input handling
│   ├── PasswordEntry.java          # Class to represent a saved password
│   ├── FileManager.java            # Handles reading/writing passwords to file
│   └── EncryptionUtils.java        # (Optional) For encrypting/decrypting data
├── data/
│   └── passwords.txt               # Text file to store saved passwords
├── README.md
```

