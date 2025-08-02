package src;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class EncryptionUtils {
    private static final String ALGORITHM = "AES";
    private static final String SECRET_KEY = "MySuperSecretKey";

    public static String encrypt(String plainText) {
        try {
            SecretKeySpec key = new SecretKeySpec(SECRET_KEY.getBytes(), ALGORITHM);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(cipher.ENCRYPT_MODE, key);

            byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            throw new RuntimeException("Error while encrypting: " + e.getMessage(), e);
        }
    }

    // Decrypt Based64 back to plain tesxt

    public static String decrypt(String encryptedText) {
        try {
            SecretKeySpec key = new SecretKeySpec(SECRET_KEY.getBytes(), ALGORITHM);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, key);

            byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
            return new String(decryptedBytes);
        } catch (Exception e) {
            throw new RuntimeException("Error while decrypting: " + e.getMessage(), e);
        }
    }

    // 🔍 Test Method: Run this file directly to test encryption
    public static void main(String[] args) {
        String original = "mypassword123";

        String encrypted = encrypt(original);
        String decrypted = decrypt(encrypted);

        System.out.println("Original:  " + original);
        System.out.println("Encrypted: " + encrypted);
        System.out.println("Decrypted: " + decrypted);
    }
}


