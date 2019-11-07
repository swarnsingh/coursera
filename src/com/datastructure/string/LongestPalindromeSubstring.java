package com.datastructure.string;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example 1:
 * <p>
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 * <p>
 * Input: "cbbd"
 * Output: "bb"
 */

/**
 * @author Swarn Singh.
 */
public class LongestPalindromeSubstring {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }

    private static boolean isPalindrome(String str) {
        for (int i = 0, j = str.length() - 1; i < str.length(); i++, j--) {
            if (j < 0) {
                j = 0;
            }
            char a = str.charAt(i);
            char b = str.charAt(j);

            if (a != b) {
                return false;
            }
        }
        return true;
    }

    public static String longestPalindrome(String s) {
        StringBuilder maxSubstring = new StringBuilder();
        if (s != null) {
            StringBuilder sb = new StringBuilder(s.length());
            int length = s.length();
            for (int i = 0; i < length; i++) {
                sb.delete(0, sb.length());
                for (int j = i; j < length; j++) {
                    char current = s.charAt(j);
                    sb.append(current);
                    if (current == sb.charAt(0)) {
                        if (isPalindrome(sb.toString())) {
                            if (sb.length() > maxSubstring.length() ) {
                                maxSubstring.replace(0, maxSubstring.length(), sb.toString());
                            }
                        }
                    }
                }
            }
        }
        return maxSubstring.toString();
    }
}
