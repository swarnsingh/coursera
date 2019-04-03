package com.datastructure.linkedlist;

/**
 * @author Swarn Singh.
 */
public class LinkedList<E> {

    int size = 0;
    Node<E> first;
    Node<E> last;

    private static class Node<E> {
        Node<E> prev;
        E item;
        Node<E> next;

        Node(Node<E> prev, E element, Node<E> next) {
            this.prev = prev;
            this.item = element;
            this.next = next;
        }
    }

    public void add(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }

    public void reverse() {

    }

    Node<E> node(int index) {
        if (index < (size >> 1)) {
            Node<E> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

    public Object[] getAll() {
        Object[] result = new Object[size];
        int i = 0;
        for (Node<E> x = first; x != null; x = x.next)
            result[i++] = x.item;
        return result;
    }

    public static void main(String[] args) {
        LinkedList<String> l = new LinkedList();
        l.add("1");
        l.add("2");
        l.add("3");
        l.add("4");
        l.add("5");
        l.add("6");

        for (Object e : l.getAll()) {
            System.out.print(e+" ");
        }

        System.out.println("\n\nAfter Reverse\n\n");
        l.reverse();
        for (Object e : l.getAll()) {
            System.out.print(e+" ");
        }

        l.add("7");
        l.add("8");

        System.out.println("\n\nAfter Add\n\n");

        for (Object e : l.getAll()) {
            System.out.print(e+" ");
        }
    }
}
