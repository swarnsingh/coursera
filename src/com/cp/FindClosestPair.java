package com.cp;

import java.util.Arrays;

/**
 * Ex:
 * I/P - 1, 60, -10, 70, -80, 15, 85
 * O/P - [-80, 85]
 *
 * @author Swarn Singh.
 */
public class FindClosestPair {

    public static int[] findPairs(int[] arr) {
        int[] pair = new int[2];
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int sum = Math.abs(arr[i] + arr[j]);
                if (minSum > sum) {
                    minSum = sum;
                    pair[0] = arr[i];
                    pair[1] = arr[j];
                }
                // System.out.println(""+arr[i] +" + "+ arr[j]+" = "+sum );
            }
        }
        return pair;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 60, -10, 70, -80, 85};
        Arrays.stream(findPairs(arr)).forEach(System.out::println);
    }
}
