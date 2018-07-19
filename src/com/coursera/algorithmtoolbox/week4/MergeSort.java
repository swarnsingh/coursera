package com.coursera.algorithmtoolbox.week4;

/**
 * @author Swarn Singh.
 */
public class MergeSort {

    private static void merge(int[] a, int[] aux, int lo, int mid, int hi) {

//        for (int k = lo; k <= hi; k++)
//            aux[k] = a[k];

        System.arraycopy(a, lo, aux, lo, (hi - lo) +1);
        int i = lo, j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (aux[j] < aux[i]) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }

    private static void sort(int[] a, int[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = {12, 11, 13, 5, 6, 7};

        int aux[] = new int[6];

        System.out.println("Given Array");
        printArray(arr);

        MergeSort ob = new MergeSort();
        ob.sort(arr, aux, 0, arr.length - 1);

        System.out.println("\nSorted array");
        printArray(arr);
    }
}
