package com.swarn.cp.string;

import java.util.*;

/**
 * Given an encoded string, return its decoded string.
 *
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 *
 * You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].
 *
 * The test cases are generated so that the length of the output will never exceed 105.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 * Example 2:
 *
 * Input: s = "3[a2[c]]"
 * Output: "accaccacc"
 * Example 3:
 *
 * Input: s = "2[abc]3[cd]ef"
 * Output: "abcabccdcdcdef"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 30
 * s consists of lowercase English letters, digits, and square brackets '[]'.
 * s is guaranteed to be a valid input.
 * All the integers in s are in the range [1, 300].
 *
 * @author swaransingh
 */
public class DecodeString {
    public static void main(String[] args) {
        String value = "3[a]2[bc]";
        System.out.println(decodeString(value));
        System.out.println(decodeString1("3[a2[c]]"));
    }

    public static String decodeString(String s) {
        List<LinkedHashMap<Integer, String>> list = new ArrayList();

        LinkedHashMap<Integer, String> map = new LinkedHashMap();
        int charCount = 0;
        StringBuilder sb = new StringBuilder("");
        int bracketCount = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                sb = new StringBuilder();
                charCount = Integer.parseInt(String.valueOf(c));
                map.put(charCount, "");
            } else if (Character.isLetter(c)) {
                sb.append(c);
                map.put(charCount, sb.toString());
            } else if (c == '[') {
                sb = new StringBuilder();
                bracketCount++;
                continue;
            } else {
                sb = new StringBuilder();
                bracketCount--;
                if (bracketCount == 0) {
                    list.add(map);
                    map = new LinkedHashMap();
                }
            }
        }

        for (LinkedHashMap<Integer, String> lMap : list) {
            int size = lMap.size();
            for (Map.Entry<Integer, String> entry : lMap.entrySet()) {
                if (size == 1) {
                    int count = entry.getKey();
                    while(count > 0) {
                        sb.append(entry.getValue());
                        count--;
                    }
                } else {

                }
            }
        }

        return sb.toString();
    }

    public static String decodeString1(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0');  // build the number k
            } else if (ch == '[') {
                numStack.push(k);  // push k to numStack
                strStack.push(currentString);  // push currentString to strStack
                currentString = new StringBuilder();  // reset currentString
                k = 0;  // reset k
            } else if (ch == ']') {
                int repeatTimes = numStack.pop();  // get the number of repetitions
                StringBuilder decodedString = strStack.pop();  // get the last string
                for (int i = 0; i < repeatTimes; i++) {
                    decodedString.append(currentString);  // append currentString repeatTimes times
                }
                currentString = decodedString;  // update currentString
            } else {
                currentString.append(ch);  // build the currentString
            }
        }

        return currentString.toString();
    }
}
