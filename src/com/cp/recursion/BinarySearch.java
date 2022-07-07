package com.cp.recursion;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        int item = 23;
        System.out.println(binarySearch(arr, item, 0, arr.length - 1));
    }

    private static int binarySearch(int[] arr, int item, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = low + (high - low) / 2;

        if (item == arr[mid]) {
            return mid;
        }
        if (item < arr[mid]) {
            return binarySearch(arr, item, low, mid - 1);
        }
        return binarySearch(arr, item, mid + 1, high);
    }
}
