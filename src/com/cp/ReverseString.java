package com.cp;

import java.util.ArrayList;
import java.util.List;

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

    public static String solve(int k, List<Integer> numbers) {
        return numbers.size() % k == 0 ? "Yes" : "No";
    }

    public static String reverseWords(String inputWords) {
        StringBuilder reverse = new StringBuilder();
        String[] arr = inputWords.split("\\s+");
        for (int i = arr.length - 1; i >= 0; i--) {
            reverse.append(arr[i] + " ");
        }
        return reverse.toString().trim();
    }

    public static List<Integer> getFirstTwoItemsWithoutPair(List<Integer> list) {
        return null;
    }

    public static String solveEncryption(String A, int B) {
        StringBuilder encryptedString = new StringBuilder();

        if ((A.length() >= 1 && A.length() <= 100000) && (B >= 1 && B <= 256)) {
            for (int i = 0; i < A.length(); i++) {
                int ascii = A.charAt(i);
                int inc = 26 % B;
                encryptedString.append((char) inc);
            }
        }

        return encryptedString.toString();
    }

    public static String solve(int A, int B) {
        int max = Integer.MIN_VALUE;
        String operation = null;

        if ((A >= -100 && A <= 100) && (B >= -100 && B <= 100 && B != 0)) {
            if (max < (A + B)) {
                max = A + B;
                operation = "+";
            }
            if (max < (A - B)) {
                max = A - B;
                operation = "-";
            }
            if (max < (A * B)) {
                max = A * B;
                operation = "*";
            }
            if (max < (A / B)) {
                max = A / B;
                operation = "/";
            }
        }

        return operation;
    }

    public static void main(String[] args) {

        System.out.println(solveEncryption("wvmctuj", 28)); //utkarsh
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

        System.out.println(solve(3, list));

        System.out.println(getFirstTwoItemsWithoutPair(list));
        System.out.println(reverseWords("agoda best apps"));

        ReverseString<Integer> reverseString = new ReverseString<>();

        Character[] character = {'a', 'b', 'c', 'd', 'e'};
        character = reverseString.reverse(character);
        System.out.println();
        for (Character i : character) {
            System.out.print(i + " ");
        }

    }
}
