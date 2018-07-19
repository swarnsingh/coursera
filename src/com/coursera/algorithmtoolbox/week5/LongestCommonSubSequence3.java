package com.coursera.algorithmtoolbox.week5;

/**
 * Task. Given three sequences 𝐴 = (𝑎1,𝑎2,...,𝑎𝑛), 𝐵 = (𝑏1,𝑏2,...,𝑏𝑚), and 𝐶 = (𝑐1,𝑐2,...,𝑐𝑙), find the length
 * of their longest common subsequence, i.e., the largest non-negative integer 𝑝 such that there exist indices
 * 1≤𝑖1 <𝑖2 <···<𝑖𝑝 ≤𝑛,1≤𝑗1 <𝑗2 <···<𝑗𝑝 ≤𝑚,1≤𝑘1 <𝑘2 <···<𝑘𝑝 ≤𝑙such that 𝑎𝑖1 = 𝑏𝑗1 = 𝑐𝑘1,...,𝑎𝑖𝑝 = 𝑏𝑗𝑝 = 𝑐𝑘𝑝
 * Input Format. First line: 𝑛. Second line: 𝑎1, 𝑎2, . . . , 𝑎𝑛. Third line: 𝑚. Fourth line: 𝑏1, 𝑏2, . . . , 𝑏𝑚.
 * Fifth line: 𝑙. Sixth line: 𝑐1,𝑐2,...,𝑐𝑙.
 * Constraints. 1 ≤ 𝑛,𝑚,𝑙 ≤ 100; −10^9 < 𝑎𝑖,𝑏𝑖,𝑐𝑖 < 10^9.
 * Output Format.
 * Output 𝑝.
 * <p>
 * Sample 1.
 * Input:
 * 3
 * 1 2 3
 * 3
 * 2 1 3
 * 3
 * 1 3 5
 * Output:
 * 2
 * A common sub sequence of length 2 is (1, 3).
 * <p>
 * Sample 2.
 * Input:
 * 5
 * 8 3 2 1 7
 * 7
 * 8 2 1 3 8 10 7 6
 * 6
 * 6 8 3 1 4 7
 * Output:
 * 3
 * One common sub sequence of length 3 in this case is (8, 3, 7). Another one is (8, 1, 7).
 */

import com.coursera.util.FastScanner;

import java.util.Arrays;

/**
 * @author Swarn Singh.
 */
public class LongestCommonSubSequence3 {
    private static int lcs3(int[] a, int[] b, int[] c) {
        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);

        int count = 0;
        for (int i = 0; i < a.length; i++) {
            int item = a[i];
            if (binarySearch(b, item) != -1 && binarySearch(c, item) != -1) {
                if (count == 3) {
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

        int k = scanner.nextInt();
        int[] c = new int[k];
        for (int i = 0; i < k; i++) {
            c[i] = scanner.nextInt();
        }

        System.out.println(lcs3(a, b, c));
    }
}
