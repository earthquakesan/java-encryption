package org.ermilov.encryption;

import static org.junit.Assert.*;

public class AESTest {

    static String password = "password";
    static String salt = "salt";

    @org.junit.Test
    public void encryptDecrypt() {
        AES encryption_1 = new AES(password, salt);
        String toEncrypt = "hello world!";
        byte[] encrypted = encryption_1.encrypt(toEncrypt);

        AES encryption_2 = new AES(password, salt);
        String decrypted = encryption_2.decrypt(encrypted);
        assertTrue(decrypted.equals(toEncrypt));
    }

    @org.junit.Test
    public void encryptionSpeedMeasurement() {
        AES encryption = new AES(password, salt);
        int size = 100000;
        String[] messages = StringFactory.generateStringArray(size);
        byte[][] encryptedMessages = new byte[size][];
        long before = System.nanoTime();
        for (int i = 0; i < size; i++) {
            encryptedMessages[i] = encryption.encrypt(messages[i]);
        }
        long encryptDuration = System.nanoTime() - before;
        long encryptDurationPerMessage = encryptDuration / size;
        String[] decryptedMessages = new String[size];
        before = System.nanoTime();
        for (int i = 0; i < size; i++) {
            decryptedMessages[i] = encryption.decrypt(encryptedMessages[i]);
        }
        long decryptDuration = System.nanoTime() - before;
        long decryptDurationPerMessage = decryptDuration / size;
        long fullDuration = encryptDuration + decryptDuration;
        long fullDurationPerMessage = fullDuration / size;
        System.out.println(encryptDurationPerMessage);
        System.out.println(decryptDurationPerMessage);
        System.out.println(fullDurationPerMessage);
    }
}