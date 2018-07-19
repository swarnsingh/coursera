package com.coursera.algorithmtoolbox.week4;

import com.coursera.util.FastScanner;

/**
 * @author Swarn Singh.
 */
public class MajorityElement {
    private static boolean getMajorityElement(int[] arr) {
        int count = 0;
        int i = 0;
        int size = arr.length;

        int complexity = 0;

        /*while (i < size/2) {
            complexity++;
            for (int j = i, k = size -1; j < size / 2; j++, k--) {
                complexity++;
                if (arr[i] == arr[k]) {
                    count++;
                }
                if (arr[i] == arr[j]) {
                    count++;
                }
                if (count > arr.length / 2) {
                    System.out.println(complexity);
                    return true;
                }
            }
            i++;
            count = 0;
        }*/

        System.out.println(complexity);
        return false;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        if (getMajorityElement(a)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
