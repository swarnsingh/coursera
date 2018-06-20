package com.coursera.algorithmtoolbox.week2;

import com.coursera.util.FastScanner;

import java.math.BigInteger;

/**
 * @author Swarn Singh.
 */
public class Fibonacci {
    static long count = 0;

    private static BigInteger calc_fib(int n) {

        long total = 1;
        long first = 0;
        long second = 1;

        for (int i = 0; i < n - 1; i++) {
            total = first + second;
            first = second;
            second = total;
            count++;
        }
        return BigInteger.valueOf(total);
    }

    public static void main(String args[]) {
        FastScanner in = new FastScanner(System.in);
        int n = in.nextInt();

        if (n > 0 && n <= 200) {
            System.out.println(calc_fib(n));
            System.out.println("Count : " + count);
        }
    }
}
