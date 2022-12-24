package com.swarn.interview.opentext;

/**
 * @author Swarn Singh.
 */
public class FormatStrings {
    public static void main(String[] args) {
        System.out.println(solution("BBABAA"));
    }

    public static int solution(String S) {
        int deleteOccurrences = 0;
        int charACount = 0;
        int charBCount = 0;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == 'A') {
                charACount++;
            } else if (c == 'B') {
                charBCount++;
            }
        }
        if (charACount == charBCount) {
            deleteOccurrences = charACount;
            return deleteOccurrences;
        }
        int tempACount = 0;

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (charACount > charBCount) {
                if (c == 'B' && tempACount < charACount) {
                    deleteOccurrences++;
                } else {
                    tempACount++;
                }
            }
        }
        return deleteOccurrences;
    }
}
