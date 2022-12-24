package com.swarn.coursera.algorithmtoolbox.week2;


import com.swarn.coursera.util.FastScanner;

/**
 * @author Swarn Singh.
 */
public class GreatestCommonDivisor {

    static long count = 0;

    static long getGCD(long val1, long val2) {
        long maxValue = val1 > val2 ? val1 : val2;
        long minValue = val1 < val2 ? val1 : val2;

        if (maxValue % minValue == 0)
            return minValue;

        long count = 0;


        for (long i = 2; i <= minValue / 2; i++) {
            count++;
            if (minValue % i == 0) {
                long val = minValue / i;
                if (maxValue % val == 0) {
                    System.out.println("Count is : " + count);
                    return val;
                }
            }
        }
        System.out.println("Count is : " + count);
        return 1;
    }

    private static long findGCD(long number1, long number2) {
        count++;
        //base case
        if(number2 == 0) {
            return number1;
        }
        return findGCD(number2, number1%number2);
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        long val1 = scanner.nextInt();
        long val2 = scanner.nextInt();
        long startTime = System.currentTimeMillis();
        System.out.println("Greatest Common Divisor of " + val1 + " & " + val2 + " is : " + findGCD(val1, val2));
        long endTime = System.currentTimeMillis();
        System.out.println("Total time : "+(endTime - startTime) + "ms");
    }
}
