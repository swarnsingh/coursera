package com.swarn.cp.recursion;

/**
 * Given a binary tree, find the length of the longest path where each node in the path has the same value. This path may or may not pass through the root.
 *
 * The length of path between two nodes is represented by the number of edges between them.
 *
 * Example 1:
 *
 * Input:
 *
 *               5
 *              / \
 *             4   5
 *            / \   \
 *           1   1   5
 *
 * Output: 2
 *
 *
 * Example 2:
 *
 * Input:
 *
 *               1
 *              / \
 *             4   5
 *            / \   \
 *           4   4   5
 *
 * Output: 2
 *
 * Note: The given binary tree has not more than 10000 nodes. The height of the tree is not more than 1000.
 */

/**
 * @author Swarn Singh
 */
public class LongestUniValuePath {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static int longestUniValuePath(TreeNode root) {
        if (root != null) {
            
        }
        return 0;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(4);
        treeNode.right = new TreeNode(5);
        treeNode.left.right = new TreeNode(1);
        treeNode.left.left = new TreeNode(1);
        treeNode.right.right = new TreeNode(5);

    }
}
