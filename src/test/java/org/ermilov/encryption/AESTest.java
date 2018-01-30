package org.ermilov.encryption;

import static org.junit.Assert.*;

public class AESTest {

    @org.junit.Test
    public void AES() {
        AES encryption = new AES("encryptionkey");
        System.out.println(encryption.toString());
    }

    @org.junit.Test
    public void encryptDecrypt() {
        AES encryption = new AES("encryptionkey");
        String toEncrypt = "hello world!";
        byte[] encrypted = encryption.encrypt(toEncrypt);
        System.out.println(encrypted.toString());
        String decrypted = encryption.decrypt(encrypted);
        System.out.println(decrypted);
    }
}