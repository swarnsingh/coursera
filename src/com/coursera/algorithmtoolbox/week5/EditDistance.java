package com.coursera.algorithmtoolbox.week5;

import com.coursera.util.FastScanner;

/**
 * Problem Introduction
 * The edit distance between two strings is the minimum number of operations (insertions, deletions, and
 * substitutions of symbols) to transform one string into another. It is a measure of similarity of two strings.
 * Edit distance has applications, for example, in computational biology, natural language processing,
 * and spell checking. Your goal in this problem is to compute the edit distance between two strings.
 * Problem Description
 * Task. The goal of this problem is to implement the algorithm for computing the edit distance between two strings.
 * Input Format. Each of the two lines of the input contains a string consisting of lower case latin letters.
 * Constraints. The length of both strings is at least 1 and at most 100.
 * Output Format. Output the edit distance between the given two strings.
 * Sample 1.
 * Input:
 * ab
 * ab
 * Output:
 * 0
 * <p>
 * Sample 2.
 * Input:
 * short
 * ports
 * Output:
 * 3
 * An alignment of total cost 3:
 * <p>
 * Sample 3.
 * Input:
 * Output:
 * 5
 * An alignment of total cost 5:
 * ab ab
 * short ports
 * s h o r t −
 * − p o r t s
 * editing
 * distance
 * e d i − t i n g −
 * − d i s t a n c e
 */

/**
 * @author Swarn Singh.
 */
public class EditDistance {
    public static int EditDistance(String s, String t) {
        //write your code here
        return 0;
    }

    public static void main(String args[]) {
        FastScanner scan = new FastScanner(System.in);

        String s = scan.next();
        String t = scan.next();

        System.out.println(EditDistance(s, t));
    }
}
