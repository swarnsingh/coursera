package com.cp.recursion;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Example 1:
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 * <p>
 * Example 2:
 * Input: s = "3[a2[c]]"
 * Output: "accaccacc"
 * <p>
 * Example 3:
 * Input: s = "2[abc]3[cd]ef"
 * Output: "abcabccdcdcdef"
 */

public class DecodeString {
    public static void main(String[] args) {
        String encodedString = "";
       // System.out.println(decodeString(encodedString));
    }

    public static String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        LinkedHashMap<Integer, Stack<LinkedHashMap<Integer, String>>> map = new LinkedHashMap<>();
        String lastChar = "";
        String regex = "[0-9]+";
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            if (x == '[') {

            } else if (x == ']') {

            } else if (regex.matches(x + "")) {

            } else {

            }
            lastChar = String.valueOf(x);
        }
        return sb.toString();
    }
}
