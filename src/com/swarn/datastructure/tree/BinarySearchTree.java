package com.swarn.datastructure.tree;

/**
 * @author Swarn Singh.
 */
public class BinarySearchTree<T extends Comparable<T>> {
    private Node<T> root;

    private static class Node<T> {
        T data;
        Node<T> left;
        Node<T> right;

        Node(T data, Node<T> left, Node<T> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    private <T extends Comparable<T>> void add(T data, Node<T> node) {
        if (node.data.compareTo(data) > 0) {
            if (node.left == null) {
                node.left = new Node(data, null, null);
            } else {
                add(data, node.left);
            }
        } else if (node.data.compareTo(data) < 0){
            if (node.right == null) {
                node.right = new Node(data, null, null);
            } else {
                add(data, node.right);
            }
        }
    }

    public void add(T data) {
        if (root == null) {
            root = new Node(data, null, null);
        } else {
            add(data, root);
        }
    }
    public Node<T> getRoot() {
        return root;
    }

    public void inorder() {
        System.out.print("The inOrder traversal is: ");
        inorder(root);
        System.out.println();
    }

    private void inorder(Node<T> node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    public boolean find(T data) {
        Node<T> parent = root;
        while (parent != null) {
            if (parent.data == data) {
                return true;
            } else if (parent.data.compareTo(data) > 0) {
                parent = parent.left;
            } else {
                parent = parent.right;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.add(38);
        bst.add(13);
        bst.add(13);
        bst.add(51);
        bst.add(10);
        bst.add(12);
        bst.add(40);
        bst.add(84);
        bst.add(25);
        bst.add(89);
        bst.add(37);
        bst.add(66);
        bst.add(95);
        bst.add(95);

        bst.inorder();

        System.out.println("\nIs 66 is available : " + bst.find(66));
        System.out.println("Is 34 is available : " + bst.find(34));

        BinarySearchTree<Character> bs = new BinarySearchTree<>();
        bs.add('g');
        bs.add('d');
        bs.add('h');
        bs.add('c');
        bs.add('f');
        bs.add('a');
        bs.add('l');
        bs.add('b');
        bs.add('n');

        bs.inorder();
        System.out.println("Is n is available : " + bs.find('n'));
    }
}
