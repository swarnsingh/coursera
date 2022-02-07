package com.interview.grab;

import java.util.*;

/**
 * @author Swarn Singh.
 */
public class Task3 {
    public static void main(String[] args) {
      //  int[] A = new int[]{-3, -2, 1, 0, 8, 7, 1};
      //  int M = 3;
        int[] A = new int[]{7, 1, 11, 8, 4, 10};
        int M = 8;
        System.out.println(solution(A, M));
    }

    public static int solution(int[] A, int M) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < A.length-1; i++) {
            for (int j = i + 1; j < A.length; j++) {
                int sum1 = Math.abs(A[i] - A[j]);
                int sum2 = Math.abs(A[j] - A[i]);
                if (sum1 % M == 0) {
                    set.add(sum1);
                }
                if (sum2 % M == 0) {
                    set.add(sum2);
                }
            }
        }
        if (set.size() == 0) {
            for (int i : A) {
                if ( i == M) {
                    set.add(i);
                    break;
                }
            }
        }
        return set.size();
    }
}
