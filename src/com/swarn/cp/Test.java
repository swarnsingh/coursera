package com.swarn.cp;

/**
 * @author Swarn Singh.
 */
public class Test {

    private static int getNoOfOperations(String str) {
        int operations = 0;
        long decimal = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            long value = Long.parseLong(Character.toString(c));
            long powValue = (long) Math.pow(2, str.length() - (i + 1));
            if (powValue != Long.MAX_VALUE || powValue != Long.MIN_VALUE) {
                decimal += value * powValue;
            }
        }

        while (decimal > 0) {
            if (decimal % 2 == 0) {
                decimal = decimal / 2;
            } else {
                decimal -= 1;
            }
            operations++;
        }
        return operations;
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            sb.append(1);
        }
        System.out.println(getNoOfOperations(sb.toString()));
    }
}
