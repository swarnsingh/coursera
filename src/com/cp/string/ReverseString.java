package com.cp.string;

/**
 * @author Swarn Singh.
 */
public class ReverseString<T> {

    public <T extends Object> T[] reverse(T[] arr) {
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

    public static void main(String[] args) {
        ReverseString<Integer> reverseString = new ReverseString<>();
        Integer[] arr = null;
        arr = reverseString.reverse(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }

        Character[] character = {'a','b','c','d','e'};
        character = reverseString.reverse(character);
        System.out.println();
        for (Character i : character) {
            System.out.print(i + " ");
        }
    }
}
