package com.cp.string;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Swarn Singh.
 */
public class ReverseString<T> {

    public <T> T[] reverse(T[] arr) {
        T temp;

        if (arr == null) {
            throw new NullPointerException("Array is null");
        }
        for (int i = 0, j = arr.length - 1; i < arr.length / 2; i++, j--) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        return arr;
    }

    public static String reverseWords(String inputWords) {
        StringBuilder reverse = new StringBuilder();
        String[] arr = inputWords.split("\\s+");
        for (int i = arr.length-1; i >= 0; i--) {
            reverse.append(arr[i]+" ");
        }
        return reverse.toString().trim();
    }

    public static List<Integer> getFirstTwoItemsWithoutPair(List<Integer> list) {
        return null;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(7);
        list.add(23);
        list.add(23);
        list.add(5);
        list.add(7);
        list.add(1);
        list.add(5);
        list.add(3);


        System.out.println(getFirstTwoItemsWithoutPair(list));
        System.out.println(reverseWords("agoda best apps"));

        ReverseString<Integer> reverseString = new ReverseString<>();

        Character[] character = {'a','b','c','d','e'};
        character = reverseString.reverse(character);
        System.out.println();
        for (Character i : character) {
            System.out.print(i + " ");
        }

    }
}
