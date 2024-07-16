package com.swarn.datastructure.tree;

import java.util.*;

/**
 * Simple Binary Tree Implementation
 * <p>
 *         38
 *       /  \
 *     13    51
 *    / \    / \
 *  10  25 40  84
 *    \      \   \
 *    12     37  89
 *                \
 *                95
 *</p>
 * @param <T> Type of data For Ex (Integer, Character, String etc.)
 * @author Swarn Singh.
 */
public class BinaryTree<T> {

    private Node<T> root;

    public Node<T> getRoot() {
        return root;
    }

    /**
     * Node class representing each node in the binary tree.
     *
     * @param <T> type of data the node holds
     */
    private static class Node<T> {
        T data;
        Node<T> left, right;

        Node(T data) {
            this.data = data;
            left = right = null;
        }
    }

    /**
     * Adds an element to the binary tree using level order traversal.
     * (Note: This might not be the most efficient approach for balanced trees,
     * consider BST insertion for efficiency)
     *
     * @param data The element to add
     */
    public void add(T data) {
        if (root == null) {
            root = new Node<>(data);
        } else {
            add(data, root);
        }
    }

    private void add(T data, Node<T> node) {
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node<T> temp = queue.poll();

            if (temp.left == null) {
                temp.left = new Node<>(data);
                break;
            } else {
                queue.offer(temp.left);
            }

            if (temp.right == null) {
                temp.right = new Node<>(data);
                break;
            } else {
                queue.offer(temp.right);
            }
        }
    }

    /**
     * Searches for an element in the binary tree using level order traversal.
     * (Note: This might not be the most efficient approach for searching large trees,
     * consider BST search for efficiency)
     *
     * @param data The element to search for
     * @return true if the element is found, false otherwise
     */
    public Boolean isAvailable(T data) {
        if (root == null) {
            return false;
        }
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node<T> temp = queue.poll();

            // Check the current node's data for a match
            if (temp.data.equals(data)) {
                return true;
            }

            // Check and enqueue non-null children for further search
            if (temp.left != null) {
                queue.offer(temp.left);
            }
            if (temp.right != null) {
                queue.offer(temp.right);
            }
        }
        return false;
    }

    /**
     * Deletes a node with the given data from the binary tree.
     * If the node to be deleted is found, it is replaced with the deepest node.
     *
     * @param data The data of the node to be deleted
     */
    public void delete(T data) {
        if (root == null) {
            return;
        }
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);

        Node<T> deletionNode = null;
        Node<T> temp = null;

        // Perform level-order traversal to find the node to delete and the last node
        while (!queue.isEmpty()) {
            temp = queue.poll();

            if (temp.data.equals(data)) {
                deletionNode = temp;
            }

            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }

        if (deletionNode != null) {
            deletionNode.data = temp.data; // temp now contains the deepest node
            deleteDeepestNode(root, temp);
        }
    }

    /**
     * Helper function to delete the deepest node in the binary tree.
     *
     * @param root        The root of the binary tree
     * @param deepestNode The deepest node to be deleted
     */
    private void deleteDeepestNode(Node<T> root, Node<T> deepestNode) {
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);

        Node<T> temp;

        while (!queue.isEmpty()) {
            temp = queue.poll();

            if (temp == deepestNode) {
                temp = null;
                return;
            }

            if (temp.right != null) {
                if (temp.right == deepestNode) {
                    temp.right = null;
                    return;
                } else {
                    queue.add(temp.right);
                }
            }

            if (temp.left != null) {
                if (temp.left == deepestNode) {
                    temp.left = null;
                    return;
                } else {
                    queue.add(temp.left);
                }
            }
        }
    }

    /**
     * Performs a level-order traversal of the tree and prints the data of each node.
     */
    public void traverse() {
        if (root == null) {
            return;
        }
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node<T> temp = queue.poll();
            System.out.print(temp.data + " ");
            if (temp.left != null) {
                queue.offer(temp.left);
            }
            if (temp.right != null) {
                queue.offer(temp.right);
            }
        }
    }

    /**
     * Performs an in-order traversal of the tree and prints the data of each node.
     *
     * @param node The starting node for in-order traversal
     */
    public void inorder(Node<T> node) {
        if (node == null) {
            return;
        }

        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    /**
     * Performs a pre-order traversal of the tree and prints the data of each node.
     *
     * @param node The starting node for pre-order traversal
     */
    public void preorder(Node<T> node) {
        if (node == null) {
            return;
        }

        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }

    /**
     * Performs a post-order traversal of the tree and prints the data of each node.
     *
     * @param node The starting node for post-order traversal
     */
    public void postorder(Node<T> node) {
        if (node == null) {
            return;
        }

        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data + " ");
    }

    /**
     * Calculates the height of the binary tree.
     *
     * @param node The root node of the binary tree (or subtree) whose height is to be calculated.
     * @return The height of the binary tree. If the tree is empty (node is null), returns -1.
     * Otherwise, returns the height of the tree, which is defined as the number of edges
     * in the longest path from the root to a leaf node.
     */
    public int heightOfTree(Node<T> node) {
        if (node == null) {
            return -1;  // An empty tree has a height of -1
        }
        int leftTreeHeight = heightOfTree(node.left);
        int rightTreeHeight = heightOfTree(node.right);
        return Math.max(leftTreeHeight, rightTreeHeight) + 1;
    }

    /**
     * Calculates the maximum depth of the binary tree.
     *
     * @param node The root node of the binary tree.
     * @return The maximum depth of the binary tree. If the tree is empty (node is null), returns 0.
     * The depth is defined as the number of edges from the root node to the farthest leaf node.
     */
    public int maxDepthOfTree(Node<T> node) {
        if (node == null) {
            return 0; // An empty tree has a depth of 0
        }
        int leftTreeDepth = maxDepthOfTree(node.left);
        int rightTreeDepth = maxDepthOfTree(node.right);
        return Math.max(leftTreeDepth, rightTreeDepth) + 1;
    }

    /**
     * Calculates the diameter of the binary tree.
     *
     * @return The diameter of the binary tree, which is the number of edges in the longest path between any two nodes.
     */
    public int diameterOfBinaryTree() {
        int[] diameter = new int[1]; // Array to store the diameter
        calculateHeight(root, diameter);
        return diameter[0];
    }

    /**
     * Helper method to calculate the height of the tree and update the diameter.
     *
     * @param node The current node.
     * @param diameter An array to store the current diameter of the tree.
     * @return The height of the current subtree.
     */
    private int calculateHeight(Node<T> node, int[] diameter) {
        if (node == null) {
            return 0;
        }

        // Recursively find the height of left and right subtrees
        int leftHeight = calculateHeight(node.left, diameter);
        int rightHeight = calculateHeight(node.right, diameter);

        // Update the diameter if the path through the current node is larger
        diameter[0] = Math.max(diameter[0], leftHeight + rightHeight);

        // Return the height of the tree rooted at the current node
        return Math.max(leftHeight, rightHeight) + 1;
    }

    /**
     * Calculates the depth of the node with the given target value in the binary tree.
     *
     * @param node        The root node of the binary tree (or subtree).
     * @param targetValue The value to search for in the tree.
     * @return The depth of the node with the target value. If the value is not found, returns -1.
     */
    public int depthOfValue(Node<T> node, T targetValue) {
        if (node == null) {
            return -1;  // Base case: tree is empty
        }

        if (node.data.equals(targetValue)) {
            return 0;  // Base case: found the target value
        }

        // Check left subtree
        int leftDepth = depthOfValue(node.left, targetValue);
        if (leftDepth != -1) {
            return leftDepth + 1;  // If found in left subtree, add 1 to the depth
        }

        // Check right subtree
        int rightDepth = depthOfValue(node.right, targetValue);
        if (rightDepth != -1) {
            return rightDepth + 1;  // If found in right subtree, add 1 to the depth
        }
        return -1;  // Value not found in either subtree
    }

    public Node invertTree(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.left != null && node.right != null) {
                Node tempNode = node.left;
                node.left = node.right;
                node.right = tempNode;

                queue.offer(node.left);
                queue.offer(node.right);
            } else if (node.left == null && node.right != null) {
                node.left = node.right;
                node.right = null;
                queue.offer(node.left);
            } else if (node.left != null && node.right == null) {
                node.right = node.left;
                node.left = null;
                queue.offer(node.right);
            }
        }
        return root;
    }

    public void addAll(T[] arr) {
        for (T item : arr) {
            add(item);
        }
    }

    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        Integer[] items = {38, 13, 13, 51, 10, 12, 40, 84, 25, 89, 37, 66, 95};

        binaryTree.addAll(items);

        System.out.println("\nIs 61 is available : " + binaryTree.isAvailable(61));
        System.out.println("Is 66 is available : " + binaryTree.isAvailable(66));
        System.out.print("Level order Traversal : ");
        binaryTree.traverse();

        System.out.println("\n");
        System.out.print("Inorder Traversal : ");
        binaryTree.inorder(binaryTree.getRoot());

        System.out.println("\n");
        System.out.print("Postorder Traversal : ");
        binaryTree.postorder(binaryTree.getRoot());

        System.out.println("\n");
        System.out.print("Preorder Traversal : ");
        binaryTree.preorder(binaryTree.getRoot());

        System.out.println("\n\nHeight of the tree from root : " + binaryTree.heightOfTree(binaryTree.getRoot()));
        System.out.println("Depth of the tree for value 66 : " + binaryTree.depthOfValue(binaryTree.getRoot(), 66));
        System.out.println("Depth of the tree for value 38 (root) : " + binaryTree.depthOfValue(binaryTree.getRoot(), 38));

        System.out.println("\n");
        binaryTree.delete(13);
        System.out.print("After deletion of 13 : ");
        binaryTree.traverse();

        System.out.println("\n");
        BinaryTree<Integer> bt = new BinaryTree<>();
        Integer[] arr = {4, 2, 7, 1, 3, 6, 9};
        bt.addAll(arr);

        bt.invertTree(bt.root);
        bt.traverse();

        System.out.println("\nMax Depth of the binary tree : "+binaryTree.maxDepthOfTree(binaryTree.getRoot()));
        System.out.println("\nDiameter of the binary tree : "+binaryTree.diameterOfBinaryTree());
    }
}
