package com.swarn.interview;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BreakingWords {

    public static void main(String[] args) {
        List<String> symbols = Arrays.asList("H", "He", "Li", "Be", "B", "C", "N", "F", "Ne", "Na", "Co", "Ni", "Cu", "Ga", "Al", "Si", "Fa");
        System.out.println(breakingBad("henry alba", symbols));
    }

    public static String breakingBad(String str, List<String> symbols) {
        Set<String> set = new HashSet<>();
        StringBuilder formatted = new StringBuilder();

        for (String symbol : symbols) {
            set.add(symbol);
        }

        String[] words = str.split("\\s+");
        for (String word : words) {
            char[] arr = word.toCharArray();
            StringBuilder max = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = i; j < arr.length; j++) {
                    String s = String.valueOf(arr[j]);
                    sb.append(s);
                    boolean contains = set.stream()
                            .anyMatch(e -> e.equalsIgnoreCase(sb.toString()));
                    if (contains) {
                        if (sb.length() > max.length()) {
                            max = new StringBuilder(sb.toString());
                        }
                    }
                }
            }
            if (!max.isEmpty()) {
                String maxValue = max.toString();
                String s = word;
                String w = set.stream()
                        .filter(e -> e.equalsIgnoreCase(maxValue))
                        .findFirst()
                        .orElse(null);
                formatted.append(s.replaceAll(max.toString(), "[" + w + "]"));
                formatted.append(" ");
            }
        }
        return formatted.toString();
    }
}
