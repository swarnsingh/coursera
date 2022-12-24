package com.swarn.cp.arrays;

import java.util.Arrays;

public class MergeSortedArrays {
    static int[] mergeArrays(int[] arr1, int[] arr2) {
        int length = arr1.length + arr2.length;
        int[] arr3 = new int[length];

        int pointer1 = 0;
        int pointer2 = 0;

        for (int i = 0; i < length; i++) {
            int min1 = Integer.MAX_VALUE;
            int min2 = Integer.MAX_VALUE;
            if (pointer1 < arr1.length) {
                if (min1 > arr1[pointer1]) {
                    min1 = arr1[pointer1];
                }
            }
            if (pointer2 < arr2.length) {
                if (min2 > arr2[pointer2]) {
                    min2 = arr2[pointer2];
                }
            }
            if (min1 <= min2) {
                arr3[i] = min1;
                pointer1++;
            } else {
                arr3[i] = min2;
                pointer2++;
            }
        }
        return arr3;
    }
    public static void main(String[] args) {
        int[] arr1 = new int[]{-5, -1, 2, 4, 8, 9};
        int[] arr2 = new int[]{-4, 0, 3, 8};
        System.out.println(Arrays.toString(mergeArrays(arr1, arr2)));
    }
}
