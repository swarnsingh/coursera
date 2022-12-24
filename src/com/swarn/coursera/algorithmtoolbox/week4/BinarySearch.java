package com.swarn.coursera.algorithmtoolbox.week4;

import com.swarn.coursera.util.FastScanner;

/**
 * Problem Description
 * Task. The goal in this code problem is to implement the binary search algorithm.
 * Input Format. The first line of the input contains an integer 𝑛 and a sequence 𝑎0 < 𝑎1 < . . . < 𝑎𝑛−1 of 𝑛 pairwise
 * distinct positive integers in increasing order. The next line contains an integer 𝑘 and 𝑘 positive integers 𝑏0, 𝑏1, . . . , 𝑏𝑘−1.
 * Constraints. 1≤𝑛,𝑘≤10^4; 1≤𝑎𝑖 ≤10^9 for all 0≤𝑖<𝑛; 1≤𝑏𝑗 ≤10^9 for all 0≤𝑗<𝑘;
 * OutputFormat. For all 𝑖 from 0 to 𝑘−1 ,output an index 0≤𝑗≤𝑛−1 such that 𝑎𝑗 = 𝑏𝑖 or−1 if there
 * is no such index.
 * Sample 1.
 * Input:
 * 5 1 5 8 12 13
 * 5 8 1 23 1 11
 * Output:
 * 2 0 -1 0 -1
 * In this sample, we are given an increasing sequence 𝑎0 = 1, 𝑎1 = 5, 𝑎2 = 8, 𝑎3 = 12, 𝑎4 = 13 of length five and five keys
 * to search: 8,1,23,1,11. We see that 𝑎2 = 8 and 𝑎0 = 1, but the keys 23 and 11 do not appear in the sequence 𝑎.
 * For this reason, we output a sequence 2, 0, −1, 0, −1.
 */

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

    private static int binarySearch0(long[] a, int fromIndex, int toIndex,
                                     long key) {
        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            long midVal = a[mid];

            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -(low + 1);  // key not found.
    }

    static int linearSearch(int[] a, int x) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }

        for (int i = 0; i < m; i++) {
            System.out.print(binarySearch(a, 0, a.length, b[i]) + " ");
        }
    }
}
