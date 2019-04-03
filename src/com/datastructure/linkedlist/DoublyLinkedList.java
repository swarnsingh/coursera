package com.datastructure.linkedlist;

/**
 * @author Swarn Singh.
 */
public class DoublyLinkedList<E> {

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
        Node newNode = new Node(lastNode, item, null);
        tail = newNode;

        if (isEmpty()) {
            head = newNode;
        } else {
            lastNode.next = newNode;
        }
        size++;
    }

    public boolean remove(E item) {
        if (isEmpty()) return false;

        Node<E> current = head;

        while (current != null) {
            if (current.item.equals(item)) {

                if (size == 1) {
                    head = null;
                    size--;
                    return true;
                }

                Node prev = current.prev;
                Node next = current.next;

                if (prev != null) {
                    prev.next = next;
                }

                if (next != null) {
                    next.prev = prev;
                }

                if (current == head) {
                    head = current.next;
                }
                current = null;
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public Object[] getAll() {
        Object[] items = new Object[size];
        int i = 0;
        for (Node<E> x = head; x != null; x = x.next) {
            items[i++] = x.item;
        }
        return items;
    }

    public Node<E> node(int index) {
        Node<E> x;
        if (index < (size >> 1)) {
            x = head;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
        } else {
            x = tail;
            for (int i = size - 1; i > index; i--) {
                x = x.prev;
            }
        }
        return x;
    }

    public void reverse() {
        if (!isEmpty()) {
            Node<E> current = head;
            Node<E> tempNode;

            while (current.next != null) {
                tempNode = current.prev;
                current.prev = current.next;
                current.next = tempNode;

                current = current.prev;
            }

            tail = head;
            tempNode = current.prev;
            current.prev = current.next;
            current.next = tempNode;

            head = current;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();

        dll.add(1);
        dll.add(5);
        dll.add(3);
        dll.add(6);
        dll.add(8);

        System.out.println("\n\nItem at index 3 is " + dll.node(3).item + "\n\n");

        dll.add(10);
        dll.add(15);

        dll.reverse();

        for (Object e : dll.getAll()) {
            System.out.print(e + " ");
        }

        dll.add(20);
        dll.add(25);

        System.out.println("\n\n");

        dll.remove(15);
        for (Object e : dll.getAll()) {
            System.out.print(e + " ");
        }
    }
}
