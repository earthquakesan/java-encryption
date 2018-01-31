package org.ermilov.encryption;

import java.util.Random;

public class StringFactory {

    private static final int minLength = 500;
    private static final int maxLength = 5000;
    private static final String alphanum = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890";

    public static String generateString() {
        Random rn = new Random();
        int length = minLength + rn.nextInt(maxLength - minLength + 1);
        StringBuilder output = new StringBuilder();
        while(output.length() < length) {
            int index = (int) (rn.nextFloat() * alphanum.length());
            output.append(alphanum.charAt(index));
        }
        return output.toString();
    }

    public static String[] generateStringArray(int size) {
        String[] output = new String[size];
        for (int i = 0; i < size; i++) {
            output[i] = generateString();
        }
        return output;
    }
}
