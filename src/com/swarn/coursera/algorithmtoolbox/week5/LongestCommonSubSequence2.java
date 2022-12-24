package com.swarn.coursera.algorithmtoolbox.week5;

import com.swarn.coursera.util.FastScanner;

import java.util.Arrays;

/**
 * Task. Given two sequences 𝐴 = (𝑎1,𝑎2,...,𝑎𝑛) and 𝐵 = (𝑏1,𝑏2,...,𝑏𝑚), find the length of their longest common
 * sub sequence, i.e., the largest non-negative integer 𝑝 such that there exist indices 1 ≤ 𝑖1 < 𝑖2 <···<𝑖𝑝 ≤𝑛
 * and1≤𝑗1 <𝑗2 <···<𝑗𝑝 ≤𝑚,such that 𝑎𝑖1 = 𝑏𝑗1,...,𝑎𝑖𝑝 = 𝑏𝑗𝑝.
 * Input Format. First line: 𝑛. Second line: 𝑎1, 𝑎2, . . . , 𝑎𝑛. Third line: 𝑚. Fourth line: 𝑏1, 𝑏2, . . . , 𝑏𝑚.
 * Constraints. 1 ≤ 𝑛, 𝑚 ≤ 100; −10^9 < 𝑎𝑖, 𝑏𝑖 < 10^9.
 * Output Format. Output 𝑝.
 * Sample 1.
 * Input:
 * 3
 * 2 7 5
 * 2
 * 2 5
 * Output:
 * 2
 * <p>
 * A common sub sequence of length 2 is (2, 5). Sample 2.
 * <p>
 * Input:
 * 1
 * 7
 * 4
 * 1 2 3 4
 * Output:
 * 0
 * The two sequences do not share elements.
 * Sample 3.
 * Input:
 * 4
 * 2 7 8 3
 * 4
 * 5 2 8 7
 * Output:
 * 2
 * One common sub sequence is (2, 7). Another one is (2, 8). Need Help?
 */

/**
 * @author Swarn Singh.
 */
public class LongestCommonSubSequence2 {

    private static int lcs2(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);

        int count = 0;
        for (int i = 0; i < a.length; i++) {
            int item = a[i];
            if (binarySearch(b, item) != -1) {
                if (count == 2) {
                    break;
                }
                count++;
            }
        }
        return count;
    }

    private static int binarySearch(int[] a, int key) {
        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            long midVal = a[mid];

            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -1;  // key not found.
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }

        System.out.println(lcs2(a, b));
    }
}
