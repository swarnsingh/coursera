package com.swarn.interview.opentext;

/**
 * If N = 14 then their each digit sum is 1 + 4 = 5
 * We need to find a minimum number whose digits sum is double or greater than N's digit's sum
 * So, 19 is the ans, 1 + 9 = 10
 *
 * @author Swarn Singh.
 */
public class FindSmallestIntegerGreaterThanN {

    public static void main(String[] args) {
        System.out.println(solution(99));
    }

    public static int solution(int N) {
        int maxSum = 0;

        String valueN = String.valueOf(N);
        int valueNSum = 0;
        for (int i = 0; i < valueN.length(); i++) {
            valueNSum += Integer.parseInt(valueN.charAt(i) + "");
        }
        for (int i = N + 1; i < Integer.MAX_VALUE; i++) {
            String maxValue = String.valueOf(i);
            int maxValueSum = 0;
            for (int j = 0; j < maxValue.length(); j++) {
                maxValueSum += Integer.parseInt(maxValue.charAt(j) + "");
            }
            if (maxValueSum >= valueNSum * 2) {
                maxSum = i;
                break;
            }
        }
        return maxSum;
    }
}
