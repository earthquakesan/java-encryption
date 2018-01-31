package org.ermilov.encryption;

import org.junit.Test;

import javax.crypto.SecretKey;

import static org.junit.Assert.*;

public class KeyGeneratorTest {

    @Test
    public void generateFromPassword() {
        String password = "password";
        String salt = "salt";
        SecretKey key1 = KeyGenerator.generateFromPassword(password, salt);
        SecretKey key2 = KeyGenerator.generateFromPassword(password, salt);
        assertTrue(key1.equals(key2));
    }
}