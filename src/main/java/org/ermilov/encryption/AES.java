package org.ermilov.encryption;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class AES implements Encryption {

    private byte[] encryptionKey = null;
    private Cipher cipher = null;
    private SecretKey secretKey = null;
    private KeyGenerator keygen = null;
    private final static String algorithm = "AES";
    private final static String algorithmInitString = "AES/ECB/PKCS5PADDING";

    public AES(String encryptionKey) {
        this.encryptionKey = encryptionKey.getBytes();
        try {
            keygen = KeyGenerator.getInstance(this.algorithm);
            keygen.init(128);
            this.secretKey = keygen.generateKey();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        try {
            this.cipher = Cipher.getInstance(this.algorithmInitString);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        }
    }

    public byte[] encrypt(String input) {
        byte[] toEncrypt = input.getBytes();
        byte[] encrypted = null;
        try {
            cipher.init(Cipher.ENCRYPT_MODE, this.secretKey);
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }

        try {
            encrypted = cipher.doFinal(toEncrypt);
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }

        return encrypted;
    }

    public String decrypt(byte[] input) {
        SecretKeySpec spec = new SecretKeySpec(secretKey.getEncoded(), "AES");

        try {
            cipher.init(Cipher.DECRYPT_MODE, spec);
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }

        byte[] decrypted = new byte[0];
        try {
            decrypted = cipher.doFinal(input);
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return new String(decrypted);
    }
}
