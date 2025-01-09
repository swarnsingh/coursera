package com.swarn.java.collections.linkedlist;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(5);
        linkedList.add(15);
        linkedList.add(52);
        linkedList.add(1);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(6);

        for (int i : linkedList) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println(linkedList.peek());
        System.out.println(linkedList.poll()); // returns first element or null if list is empty
        System.out.println(linkedList.pop()); // returns first element or throws NoSuchElementException if list is empty
        for (int i : linkedList) {
            System.out.print(i + " ");
        }

        linkedList.sort(Collections.reverseOrder()); // this will sort in decreasing order
        System.out.println();
        for (int i : linkedList) {
            System.out.print(i + " ");
        }
    }
}
