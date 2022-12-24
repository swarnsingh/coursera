package com.swarn.cp.arrays;

/**
 * @author Swarn Singh.
 */
public class ArrangeZeros {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 0, 2, 0, 3, 0, 4, 5, 0, 0};

        arrange(arr);
        for (int item : arr) {
            System.out.print(item + " ");
        }
    }

    public static int[] arrange(int[] arr) {
        int j = arr.length - 1;
        int i = 0;
        while (i < arr.length - 1) {
            if (i == j) {
                break;
            }
            if (arr[i] == 0) {
                if (arr[j] != 0) {
                    arr[i] = arr[j];
                    arr[j] = 0;
                    i++;
                    j--;
                }
            } else {
                i++;
            }
            if (arr[j] == 0) {
                j--;
            }
        }
        return arr;
    }
}
