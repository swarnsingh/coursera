package com.swarn.cp.trees;

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }
}

public class BST {
    private Node root;

    public void insert(int value) {
        root = insert(root, value);
    }

    private Node insert(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }
        if (value < node.value) {
            node.left = insert(node.left, value);
        } else if (value > node.value) {
            node.right = insert(node.right, value);
        } else {
            return node;
        }
        return node;
    }

    public void inOrder() {
        System.out.print("The inOrder traversal is: ");
        inOrder(root);
        System.out.println();
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);
    }

    public void preOrder() {
        System.out.print("The preOrder traversal is: ");
        preOrder(root);
        System.out.println();
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void postOrder() {
        System.out.print("The postOrder traversal is: ");
        postOrder(root);
        System.out.println();
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");
    }

    public boolean find(int value) {
        Node node = root;
        while (node != null) {
            if (node.value == value) {
                return true;
            } else if (value <= node.value) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        BST bst = new BST();
        bst.insert(7);
        bst.insert(20);
        bst.insert(5);
        bst.insert(15);
        bst.insert(10);
        bst.insert(4);
        bst.insert(33);
        bst.insert(2);
        bst.insert(25);
        bst.insert(6);
        bst.insert(6);

        bst.inOrder();
        bst.preOrder();
        bst.postOrder();
        System.out.println(bst.find(7));
    }
}
