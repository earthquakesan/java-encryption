package org.ermilov.encryption;

public interface Encryption {
    public byte[] encrypt(String input);
    public String decrypt(byte[] input);
}
