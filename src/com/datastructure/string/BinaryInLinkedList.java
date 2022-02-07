package com.datastructure.string;

import java.util.Collections;
import java.util.List;

/**
 * @author Swarn Singh.
 */
public class BinaryInLinkedList {

    public static long getNumber(int m) {
        long number = Long.parseLong("011", 2);
        return number;


    }

    public static void main(String[] args) throws Exception {
        System.out.println(getNumber(5));

        int year = 1901;
        int days = 0;
        for (int i = 1900; i < year; i++) {
            if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
                days = days + 366;
            } else {
                days = days + 365;
            }
        }

        System.out.println(days);
    }

    public static int maxTickets(List<Integer> tickets) {
        Collections.sort(tickets);
        int max = 0;
        int count = 0;
        int prev = 0;
        for (int i = 0; i < tickets.size(); i++) {
            int value = tickets.get(i);
            if (value == prev || value == prev + 1) {
                prev = value;
                count++;
            } else {
                count = 0;
                prev = value;
                count++;
            }
            if (count > max) {
                max = count;
            }
        }
        return max;
    }

    static boolean isPrime(int n) {
        // Corner cases
        if (n <= 1)
            return false;
        if (n <= 3)
            return true;
        if (n % 2 == 0 || n % 3 == 0)
            return false;

        for (int i = 5; i * i <= n; i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;

        return true;
    }

    // Function to check if the number is circular
    // prime or not.
    static boolean checkCircular(int N) {
        // Count digits.
        int count = 0, temp = N;
        while (temp > 0) {
            count++;
            temp /= 10;
        }

        int num = N;
        while (isPrime(num)) {
            int rem = num % 10;
            int div = num / 10;
            num = (int) ((Math.pow(10, count - 1)) * rem)
                    + div;
            if (num == N)
                return true;
        }
        return false;
    }

    class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;
    }
}


