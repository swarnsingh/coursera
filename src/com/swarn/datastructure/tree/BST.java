package com.swarn.datastructure.tree;

/**
 * It's an Unbalanced Binary Search Tree with duplicates allowed
 * <p>
 * Time Complexity - O(n)
 *
 * @author Swarn Singh.
 */
public class BST<T extends Comparable<T>> {

    private Node<T> root;

    public Node<T> getRoot() {
        return root;
    }

    private static class Node<T> {
        T data;
        int count = 1;
        Node<T> left, right;

        Node(T data) {
            this.data = data;
            left = right = null;
        }
    }

    private void insert(T data, Node<T> node) {
        if (node.data.compareTo(data) > 0) {
            if (node.left == null) {
                node.left = new Node(data);
            } else {
                insert(data, node.left);
            }
        } else if (node.data.compareTo(data) < 0) {
            if (node.right == null) {
                node.right = new Node(data);
            } else {
                insert(data, node.right);
            }
        } else {
            node.count++;
        }
    }

    public void insert(T data) {
        if (root == null) {
            root = new Node(data);
        } else {
            insert(data, root);
        }
    }

    public Node isAvailable(T data) {
        Node<T> node = root;

        while (node != null) {
            if (node.data.equals(data)) {
                return node;
            } else if (node.data.compareTo(data) > 0) {
                node = node.left;
            } else {
                node = node.right;
            }
        }

        return null;
    }

    public Node<T> inorderSuccessor(T data) {
        Node<T> node = isAvailable(data);
        Node<T> successor = null;
        if (node != null && node.right != null) {
            Node<T> leftMost = node.right;
            while (leftMost.left != null) {
                leftMost = leftMost.left;
                successor = leftMost;
            }
        } else {
            Node<T> current = root;
            while (current != null) {
                if (node.data.compareTo(current.data) < 0) {
                    successor = current;
                    current = current.left;
                } else if (node.data.compareTo(current.data) > 0) {
                    current = current.right;
                } else {
                    break;
                }
            }
        }
        return successor;
    }


    public void delete(Node<T> node, T data) {
        if (node == null) {
            return;
        }
        if (data.compareTo(node.data) < 0) {
            delete(node.left, data);
        } else if (data.compareTo(node.data) > 0) {
            delete(node.right, data);
        } else {

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
        int count = node.count;
        while (count > 0) {
            System.out.print(node.data + " ");
            count--;
        }
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

        int count = node.count;
        while (count > 0) {
            System.out.print(node.data + " ");
            count--;
        }
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
        int count = node.count;
        while (count > 0) {
            System.out.print(node.data + " ");
            count--;
        }
    }

    public static void main(String[] args) {
        BST bst = new BST();
        bst.insert(13);
        bst.insert(18);
        bst.insert(7);
        bst.insert(8);
        bst.insert(3);
        bst.insert(14);
        bst.insert(19);
        bst.insert(19);
        bst.insert(15);

        System.out.print("\nInorder Traversal   : ");
        bst.inorder(bst.getRoot());

        System.out.print("\nPreorder Traversal  : ");
        bst.preorder(bst.getRoot());

        System.out.print("\nPostorder Traversal : ");
        bst.postorder(bst.getRoot());

        boolean isAvailable = bst.isAvailable(15) != null;
        System.out.println("\n\nIs 15 available : " + isAvailable);

        isAvailable = bst.isAvailable(20) != null;
        System.out.println("Is 20 available : " + isAvailable);

        System.out.println("\nInorder successor of root : " + bst.inorderSuccessor(8).data);
    }
}
