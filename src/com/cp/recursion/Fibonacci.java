package com.cp.recursion;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    private static Map<Long, Long> map = new HashMap<>();
    private static long count = 0;

    public static void main(String[] args) {
        long value = 6;
        System.out.println(fibonacci(value));
        System.out.println("Fibonacci Total of " + value + " is : " + fib(value));
        System.out.println("Count : " + count);
    }

    private static long fibonacci(long n) {
        if (n < 2) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }


    /**
     * Using Memoization to avoid duplicate calls.
     */
    private static long fib(long n) {
        count++;
        if (n < 2) {
            return n;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }
        long result = fib(n - 1) + fib(n - 2);
        map.put(n, result);
        return result;
    }
}
