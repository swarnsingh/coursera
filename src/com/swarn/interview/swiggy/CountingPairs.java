package com.swarn.interview.swiggy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Swarn Singh.
 */
public class CountingPairs {
    public static void main(String[] args) throws IOException {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(2);
        numbers.add(3);
        numbers.add(3);

        int result = Result.countPairs(numbers, 1);

        System.out.println("Result : " + result);
    }
}

class Pair<T, U> {
    public final T key;
    public final U value;

    public Pair(T key, U value) {
        this.key = key;
        this.value = value;
    }

    public static boolean isPairAvailable(int a, int b, List<Pair<Integer, Integer>> list) {
        boolean isAvailable = false;
        for (Pair<Integer, Integer> pair : list) {
            if (a == pair.key && b == pair.value) {
                isAvailable = true;
                break;
            }
        }
        return isAvailable;
    }
}

class Result {

    /*
     * Complete the 'countPairs' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY numbers
     *  2. INTEGER k
     */

    public static int countPairs(List<Integer> numbers, int k) {
        int validPairCount = 0;
        List<Pair<Integer, Integer>> pairs = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i; j < numbers.size(); j++) {
                int a = numbers.get(i);
                int b = numbers.get(j);

                if (Pair.isPairAvailable(a, b, pairs)) {
                    continue;
                }
                pairs.add(new Pair(a, b));
                int value = a + k;
                if (value == b) {
                    validPairCount++;
                }
            }
        }
        return validPairCount;
    }
}
