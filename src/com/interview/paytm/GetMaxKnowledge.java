package com.interview.paytm;

import java.util.*;

/**
 * STDIN Function
 * ----- --------
 * 10 → d = 10
 * 4 → n = 4
 * 2  →  s = [2, 6, 4, 3]
 * 6
 * 4
 * 3
 * 4      →  n = 4
 * 8      →  e = [8, 9, 7, 5]
 * 9
 * 7
 * 5
 * 4      →  n = 4
 * 900   →  a = [900, 1600, 2000, 400]
 * 1600
 * 2000
 * 400
 * 3  →  k = 3
 * <p>
 * O/p - 4500
 *
 * @author Swarn Singh.
 */
public class GetMaxKnowledge {
    public static long getMaxKnowledge(int d, List<Integer> s, List<Integer> e, List<Integer> a, int k) {
        long maxKnowledge = 0L;

        for (int i = 1; i <= d; i++) {
            long max = 0L;
            List<Long> values = new ArrayList<>();
            for (int j = 0; j < s.size(); j++) {
                long value = s.get(j);
                if (value <= i) {
                    values.add(Long.valueOf(a.get(j)));
                }
            }
            values.sort(Comparator.reverseOrder());
            for (int m = 0; m < values.size() && m < k; m++) {
                max += values.get(m);
            }
            if (max > maxKnowledge) {
                maxKnowledge = max;
            }
        }
        return maxKnowledge;
    }

    public static void main(String[] args) {
        int d = 10;
        List<Integer> s = Arrays.asList(2, 6, 4, 3);
        List<Integer> e = Arrays.asList(8, 9, 7, 5);
        List<Integer> a = Arrays.asList(900, 1600, 2000, 400);
        int k = 3;

        System.out.println("\n\n Max Knowledge : " + getMaxKnowledge(d, s, e, a, k));
    }
}
