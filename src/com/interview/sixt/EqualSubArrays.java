package com.interview.sixt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Input
 * 3
 * 1 1 2
 * 2
 * 1 1
 * Output
 * 1
 * Expected Correct Output
 * 1
 *
 * Explanation :
 * There exists no sub-array of b containing 2 as an element. So, 2 is not good integer.
 *
 * @author Swarn Singh.
 */
public class EqualSubArrays {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine().trim());
        String[] arr_A = br.readLine().split(" ");
        int[] A = new int[N];
        for(int i_A = 0; i_A < arr_A.length; i_A++)
        {
            A[i_A] = Integer.parseInt(arr_A[i_A]);
        }
        int M = Integer.parseInt(br.readLine().trim());
        String[] arr_B = br.readLine().split(" ");
        int[] B = new int[M];
        for(int i_B = 0; i_B < arr_B.length; i_B++)
        {
            B[i_B] = Integer.parseInt(arr_B[i_B]);
        }

        int out_ = solve(N, A, M, B);
        System.out.println(out_);

        wr.close();
        br.close();
    }
    static int solve(int N, int[] A, int M, int[] B){
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            boolean isEqual = false;
            for (int j = 0; j < B.length; j++) {
                if (A[i] == B[j]) {
                    isEqual = true;
                    break;
                }
            }
            if (!isEqual) {
                result++;
            }
        }
        return result;
    }
}
