package com.cp.recursion;

public class ReverseNumber {
    public static void main(String[] args) {
        System.out.println(reverse(987654321L));
    }

    static long reverse(long n) {
        if (n % 10 == 0) {
            return n;
        }
        long length = (long) (Math.log10(n) + 1);

        return (long) ((n % 10) * Math.pow(10, length - 1) + reverse(n / 10));
    }
}
