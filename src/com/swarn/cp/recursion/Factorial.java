package com.swarn.cp.recursion;

public class Factorial {

    public static void main(String[] args) {
        System.out.println(fact(5));
    }

    static int fact(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 0) {
            return 0;
        }
        return n * fact(n - 1);
    }
}
