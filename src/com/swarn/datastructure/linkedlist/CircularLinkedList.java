package com.swarn.datastructure.linkedlist;

/**
 * @author Swarn Singh.
 */
public class CircularLinkedList<E> {

    private Node<E> head;
    Node<E> tail;
    int size = 0;

    private static class Node<E> {
        Node<E> prev;
        E item;
        Node<E> next;

        public Node(Node<E> prev, E item, Node<E> next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E item) {
        Node<E> lastNode = tail;
        Node newNode = new Node(lastNode, item, head);
        tail = newNode;

        if (isEmpty()) {
            newNode.prev = newNode;
            newNode.next = newNode;
            head = tail;
        } else {
            lastNode.next = newNode;
            head.prev = newNode;
        }
        size++;
    }

    public Object[] getAll() {
        Object[] items = new Object[size];
        int i = 0;
        for (Node<E> x = head; i < size; x = x.next) {
            items[i++] = x.item;
        }
        return items;
    }

    public static void main(String[] args) {
        CircularLinkedList<Integer> cll = new CircularLinkedList<>();

        cll.add(1);
        cll.add(5);
        cll.add(3);
        cll.add(6);
        cll.add(8);

        for (Object e : cll.getAll()) {
            System.out.print(e + " ");
        }
    }

}
