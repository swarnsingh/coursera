package com.swarn.java.collections.set;

import java.util.LinkedHashSet;

/**
 * Java LinkedHashSet class contains unique elements only like HashSet.
 * Java LinkedHashSet class provides all optional set operations and permits null elements.
 * Java LinkedHashSet class is non-synchronized.
 * Java LinkedHashSet class maintains insertion order.
 * <p>
 * Time Complexity: LinkedHashSet has constant time complexity O(1) for basic operations like add, remove, and contains,
 * similar to HashSet.
 * Space Complexity: It uses more memory than HashSet because it maintains a doubly linked list to preserve the order of insertion.
 */

public class LinkedHashSetTest {
    public static void main(String[] args) {
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(1);
        linkedHashSet.add(3);
        linkedHashSet.add(2);
        linkedHashSet.add(3);
        linkedHashSet.add(12);
        linkedHashSet.add(11);
        linkedHashSet.add(5);

        for (int i : linkedHashSet) {
            System.out.println(i + " ");
        }

        linkedHashSet.add(10);
        linkedHashSet.remove(3);
        System.out.println();
        for (int i : linkedHashSet) {
            System.out.println(i + " ");
        }
    }
}
