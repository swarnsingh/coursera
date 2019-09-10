package com.datastructure.tree;

/**
 * @author Swarn Singh.
 */
public class BinarySearch {
    static int binarySearch(int[] a, int low, int high, int key) {

        int mid = low + ((high - low) / 2);

        if (mid >= a.length) {
            return -1;
        } else if (key == a[mid]) {
            return mid;
        } else if (low >= high) {
            return -1;
        } else if (key < a[mid]) {
            return binarySearch(a, low, mid - 1, key);
        } else {
            return binarySearch(a, mid + 1, high, key);
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        int key = 11;
        System.out.println("Find element "+key+" in array at position -> "+binarySearch(arr, 0, arr.length, key));
    }
}
