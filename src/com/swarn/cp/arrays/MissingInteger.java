package com.swarn.cp.arrays;

import java.util.HashSet;

public class MissingInteger {

    static int findMissingInteger(int[] arr) {
        int value = arr.length + 1;
        HashSet<Integer> hashSet = new HashSet<>(arr.length);
        for (int j : arr) {
            hashSet.add(j);
        }

        for (int i = 0; i < arr.length; i++) {
            if (!hashSet.contains(i + 1)) {
                value = i + 1;
                break;
            }
        }
        return value;
    }

    static int findMissingInteger1(int[] arr) {
        int value = arr.length + 1;

        for (int i = 0; i < arr.length; i++) {
            int item = arr[i];

            if (item <= 0 || item > arr.length || item == i + 1 || arr[item - 1] == item) {
                continue;
            }
            int temp = arr[item - 1];
            arr[item - 1] = item;
            arr[i] = temp;
            i--;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                value = i + 1;
                break;
            }
        }
        return value;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{8, 10, 2, 1, -1, 2, 8, 7, 9};
        System.out.println(findMissingInteger(arr));
        System.out.println(findMissingInteger1(arr));
    }
}
