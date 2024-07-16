package com.swarn.java.collections.set;

import java.util.*;

/**
 * Java TreeSet class contains unique elements only like HashSet.
 * Java TreeSet class access and retrieval times are quiet fast.
 * Java TreeSet class doesn't allow null element.
 * Java TreeSet class is non synchronized.
 * Java TreeSet class maintains ascending order.
 * <p>
 * The TreeSet can only allow those generic types that are comparable. For example The Comparable interface is being
 * implemented by the StringBuffer class.
 * <p>
 * TreeSet is being implemented using a binary search tree, which is self-balancing just like a Red-Black Tree.
 * Therefore, operations such as a search, remove, and add consume O(log(N)) time. The reason behind this is there in
 * the self-balancing tree. It is there to ensure that the tree height never exceeds O(log(N)) for all the mentioned
 * operations. Therefore, it is one of the efficient data structures in order to keep the large data that is sorted and
 * also to do operations on it.
 * <p>
 * Time Complexity: O(log n)
 * <p>
 * Space Complexity : O(n)
 */

public class TreeSetTest {
    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet(Collections.reverseOrder());
        List<String> list = Arrays.asList("Vijay", "Ajay", "Ajay Singh", "Swarn Singh", "Tony", "Aman", "Rohan");

        treeSet.addAll(list);

        System.out.println(treeSet);

        treeSet.remove("Ajay");

        System.out.println(treeSet);
    }
}
