package com.swarn.cp.arrays;

import java.util.Arrays;

/**
 * Find max pairs count where arr 1 element is bigger than arr 2 element
 * arr1 = [7,8,2,4]
 * arr2 = [3,5,1,10]
 * <p>
 * max pairs = (7,3)(7,5)(7,1)
 * (8,3)(8,5)(8,1)
 * (2,1)
 * (4,3)(4,1)
 * <p>
 * count = 9
 */
public class MaxPairCount {

    // O (N Log N + M Log M)
    static int maxPairCount(int[] arr1, int[] arr2) {
        int count = 0;

        int N = arr1.length;
        int M = arr2.length;
        int p1 = 0;
        int p2 = 0;
        Arrays.sort(arr1); // O(N log N)
        Arrays.sort(arr2); // O(M log M)

        // O(N + M)
        int i = 0;
        while (p1 < N && p2 < M) {
            i++;
            if (arr1[p1] <= arr2[p2]) {
                p1++;
            } else {
                count += N - p1;
                p2++;
            }
        }
        System.out.println("I : " + i);
        return count;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{10, 11, 12, 13};
        int[] arr2 = new int[]{15, 5, 1, 6, 4, 3, 20};

        System.out.println(maxPairCount(arr1, arr2));
    }
}
