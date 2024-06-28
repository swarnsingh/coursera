package com.swarn.java.collections.set;

import java.util.HashSet;

/**
 * HashSet stores the elements by using a mechanism called hashing.
 * HashSet contains unique elements only.
 * HashSet allows null value.
 * HashSet class is non synchronized.
 * HashSet doesn't maintain the insertion order. Here, elements are inserted on the basis of their hashcode.
 * HashSet is the best approach for search operations.
 * The initial default capacity of HashSet is 16, and the load factor is 0.75.
 * <p>
 * Use a HashSet when you need to store unique elements and ensure no duplicates.
 * It provides O(1) average time complexity for add, remove, and contains operations.
 * Ideal for fast lookups, removing duplicates, set operations, and tracking visited elements.
 * Common in problems involving checking for duplicates, finding unique elements, and performing set-based calculations.
 * <p>
 * Example 1: Finding Duplicates
 * You can use a HashSet to check for duplicates in an array or list efficiently.
 */
public class HashSetTest {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("Ajay Singh");
        set.add("Ravi");
        set.add("Vijay");
        set.add("Ajay");
        set.add("Ravi");
        set.add("Ajay");
        set.add(null);
        set.add(null);

        for (String s : set) {
            System.out.println(s);
        }

        System.out.println();
        System.out.println("Vijay contains : " + set.contains("Vijay"));
        set.removeIf(str -> str != null && str.contains("Vijay"));
        System.out.println();

        for (String s : set) {
            System.out.println(s);
        }
    }
}
