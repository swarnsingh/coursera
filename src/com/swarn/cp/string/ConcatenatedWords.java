package com.swarn.cp.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of strings words (without duplicates), return all the concatenated words in the given list of words.
 * <p>
 * A concatenated word is defined as a string that is comprised entirely of at least two shorter words (not necessarily distinct) in the given array.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: words = ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
 * Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]
 * Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats";
 * "dogcatsdog" can be concatenated by "dog", "cats" and "dog";
 * "ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat".
 * Example 2:
 * <p>
 * Input: words = ["cat","dog","catdog"]
 * Output: ["catdog"]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= words.length <= 104
 * 1 <= words[i].length <= 30
 * words[i] consists of only lowercase English letters.
 * All the strings of words are unique.
 * 1 <= sum(words[i].length) <= 105
 *
 * @author swaransingh
 */

public class ConcatenatedWords {

    public static void main(String[] args) {
        String[] words = new String[]{"cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat",
                "ratcatdogcat"};
        findAllConcatenatedWordsInADict(words);
    }

    public static List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> list = new ArrayList<>();

        for (String word : words) {
            StringBuilder sb = new StringBuilder(word);
            String bgMatcher = "";
            boolean flag = true;
            while (!sb.isEmpty() && flag) {
                for (String matcher : words) {
                    if (sb.toString().startsWith(matcher) && !matcher.equals(word)) {
                        if (bgMatcher.length() < matcher.length()) {
                            bgMatcher = matcher;
                        }
                    }
                }
                if (!bgMatcher.isEmpty()) {
                    sb.delete(0, bgMatcher.length());
                    bgMatcher = "";
                } else {
                    flag = false;
                }
            }
            if (sb.isEmpty()) {
                list.add(word);
            }
        }

        return list;
    }
}
