package org.ermilov.encryption;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringFactoryTest {

    @Test
    public void generateString() {
        String str_1 = StringFactory.generateString();
        System.out.println(str_1);
    }

    @Test
    public void generateStringArray() {
        String[] str = StringFactory.generateStringArray(10);
        System.out.println(str[5]);
    }
}