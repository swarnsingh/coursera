package com.datastructure.string;


/**
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Example 1:
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * <p>
 * <p>
 * Example 2:
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * <p>
 * <p>
 * Example 3:
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

/**
 * @author Swarn Singh.
 */
public class LongestSubstring {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("ohvhjdml"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s != null && s.length() > 0) {
            StringBuilder max = new StringBuilder(s.length());
            StringBuilder sb = new StringBuilder(s.length());

            max.append(s.charAt(0));
            sb.append(s.charAt(0));

            for (int i = 1; i < s.length(); i++) {
                char currentChar = s.charAt(i);
                if (sb.toString().contains(s.subSequence(i, i + 1))) {
                    sb.delete(0, sb.indexOf(String.valueOf(currentChar)) + 1);
                    sb.append(currentChar);
                } else {
                    sb.append(currentChar);
                }
                if (sb.length() > max.length()) {
                    max.replace(0, max.length(), sb.toString());
                }
            }
            System.out.println("Max String : " + max);
            return max.length();
        }
        return 0;
    }
}
