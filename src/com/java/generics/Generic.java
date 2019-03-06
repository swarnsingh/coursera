package com.java.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Swarn Singh.
 */
public class Generic<T> {
    public static <T extends Number> void printNumbers(T t) {
        System.out.println(t);
    }

    public static <T extends CharSequence> void printStrings(T t) {
        System.out.println(t);
    }

    public static <T> void printItem(T t) {
        System.out.println(t);
    }

    public static void printListItems(List<?> items) {
        for (Object o : items) {
            System.out.println(o);
        }
    }

    public static void main(String[] args) {
        printNumbers(10);
        printStrings("123");

        List<String> list1 = new ArrayList<>();
        list1.add("abc");
        list1.add("def");
        list1.add("ghi");

        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);

        printListItems(list1);
        printListItems(list2);

        printItem(list2);
    }
}
