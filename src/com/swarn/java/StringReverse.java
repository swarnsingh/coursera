package com.swarn.java;

public class StringReverse {

    public static void main(String[] args) {
        String input ="This is the string to be reversed";
        System.out.println(reverseString(input));
        //output="desrever eb ot gnirts eht si sihT"
    }

    public static String reverseString(String input) {
        StringBuilder sb = new StringBuilder();

        for (int i = input.length() - 1; i >= 0; i--) {
            sb.append(input.charAt(i));
        }
        return sb.toString();
    }
}
