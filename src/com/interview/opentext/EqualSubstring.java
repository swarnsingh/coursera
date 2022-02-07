package com.interview.opentext;

/**
 * @author Swarn Singh.
 */
public class EqualSubstring {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        String s = "xcomputer";
        String s1 = "com"; // true
        String s2 = "comx"; // false
        System.out.println(isEqualSubstring(s, s1));
    }

    public static boolean isEqualSubstring(String s, String s1) {
        int j = 0;
        boolean isEqual = false;
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = s1.charAt(j);

            if (c1 == c2) {
                if (j == s1.length() - 1) {
                    isEqual = true;
                    break;
                }
                j++;
            } else {
                j = 0;
            }
        }
        return isEqual;
    }
}
