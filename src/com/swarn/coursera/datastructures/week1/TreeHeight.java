package com.swarn.coursera.datastructures.week1;

/**
 * Problem Description
 * Task.
 * You are given a description of a rooted tree. Your task is to compute and output its height. Recall that the
 * height of a (rooted) tree is the maximum depth of a node, or the maximum distance from a leaf to the root. You are given
 * an arbitrary tree, not necessarily a binary tree.
 * Input Format. The first line contains the number of nodes 𝑛. The second line contains 𝑛 integer numbers from −1 to
 * 𝑛 − 1 — parents of nodes. If the 𝑖-th one of them (0 ≤ 𝑖 ≤ 𝑛 − 1) is −1, node 𝑖 is the root, otherwise it’s 0-based index
 * of the parent of 𝑖-th node. It is guaranteed that there is exactly one root. It is guaranteed that the input represents
 * a tree.
 * Constraints. 1 ≤ 𝑛 ≤ 10^5.
 * Output Format.
 * Output the height of the tree.
 * Time Limits. C: 1 sec, C++: 1 sec, Java: 6 sec, Python: 3 sec. C#: 1.5 sec, Haskell: 2 sec, JavaScript: 3 sec,
 * Ruby: 3 sec, Scala: 3 sec.
 * Memory Limit. 512MB.
 * <p>
 * Sample 1.
 * Input:
 * 5
 * 4 -1 4 1 1
 * <p>
 * Output:
 * 3
 * <p>
 * Explanation:
 * The input means that there are 5 nodes with numbers from 0 to 4, node 0 is a child of node 4, node 1 is the root,
 * node 2 is a child of node 4, node 3 is a child of node 1 and node 4 is a child of node 1. To see this, let us write
 * numbers of nodes from 0 to 4 in one line and the numbers given in the input in the second line underneath:
 * 0 1 2 3 4
 * 4 -1 4 1 1
 * Now we can see that the node number 1 is the root, because −1 corresponds to it in the second line. Also, we know that
 * the nodes number 3 and number 4 are children of the root node 1. Also, we know that the nodes number 0 and number 2
 * are children of the node 4.
 * 5
 * 4 -1 4 1 1
 */

import com.swarn.coursera.util.FastScanner;

import java.io.IOException;

/**
 * @author Swarn Singh.
 */
public class TreeHeight {

    public static class Height {
        int n;
        int[] parent;

        void read() throws IOException {
            FastScanner in = new FastScanner(System.in);
            n = in.nextInt();
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = in.nextInt();
            }
        }

        int computeHeight() {
            int maxHeight = 0;
            for (int vertex = 0; vertex < n; vertex++) {
                int height = 0;
                for (int i = vertex; i != -1; i = parent[i])
                    height++;
                maxHeight = Math.max(maxHeight, height);
            }
            return maxHeight;
        }
    }

    static public void main(String[] args) {
        new Thread(null, () -> {
            try {
                new TreeHeight().run();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }, "1", 1 << 26).start();
    }

    public void run() throws IOException {
        Height tree = new Height();
        tree.read();
        System.out.println(tree.computeHeight());
    }
}
