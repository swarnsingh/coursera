package com.coursera.algorithmtoolbox.week1;

import com.coursera.util.FastScanner;

/**
 * @author Swarn Singh.
 */
public class Palindrome {

    static boolean isPalindrome(String str) {

        int count = 0;

        for (int i = 0, j = str.length() - 1; i < str.length() / 2; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) {
                System.out.println("Count is : " + count);
                return false;
            }
            count++;
        }
        System.out.println("Count is : " + count);
        return true;
    }

    public static void main(String[] args) {

        FastScanner scanner = new FastScanner(System.in);

        String str = scanner.next();

        System.out.println("Is " + str + " is palindrome : " + isPalindrome(str));
    }
}
