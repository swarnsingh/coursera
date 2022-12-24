package com.swarn.cp.string;

/**
 * @author Swarn Singh.
 */
public class Palindrome {

    public static boolean isPalindrome(String str) {
        str = str.toUpperCase();

        for (int i = 0, j = str.length() - 1; i < str.length(); ) {
            if (j < 0) {
                j = 0;
            }
            char a = str.charAt(i);
            char b = str.charAt(j);
            if (Character.isLetterOrDigit(a) && Character.isLetterOrDigit(b)) {
                if (a != b) {
                    return false;
                }
                i++;
                j--;
            }
            if (!Character.isLetterOrDigit(a)) {
                i++;
            }
            if (!Character.isLetterOrDigit(b)) {
                j--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama\"";
        System.out.println("\n \"" + str + " is palindrome : " + isPalindrome(str));
    }
}
