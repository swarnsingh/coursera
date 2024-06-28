package com.swarn.java.collections.arraylist;

import java.util.Arrays;
import java.util.Collections;

public class ArrayListTest {
    public static void main(String[] args) {
        var list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 13, 4, 10);
        // sort in increasing order
        Collections.sort(list);
        for (int i : list) {
            System.out.print(i + " ");
        }

        // sort in decreasing order
        list.sort(Collections.reverseOrder());
        System.out.println();
        for (int i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
