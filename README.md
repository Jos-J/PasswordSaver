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
├── data/
│   └── passwords.txt               # Text file to store saved passwords
├── README.md
├── src/
│   ├── PasswordSaver.java          # Main class with menu & input handling
│   ├── PasswordEntry.java          # Class to represent a saved password
│   ├── FileManager.java            # Handles reading/writing passwords to file
│   └── EncryptionUtils.java        # (Optional) For encrypting/decrypting data

```

### License

![MIT License](https://img.shields.io/badge/License-MIT-blue.svg)

Copyright (c) 2025 Jos

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.