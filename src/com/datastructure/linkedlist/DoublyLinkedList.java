package com.datastructure.linkedlist;

/**
 * @author Swarn Singh.
 */
public class DoublyLinkedList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size = 0;

    private static class Node<E> {
        Node<E> prev;
        E item;
        Node<E> next;

        Node(Node<E> prev, E item, Node<E> next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void checkPositionIndex(int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    public boolean add(E item) {
        linkLast(item);
        return true;
    }

    private void linkLast(E item) {
        Node<E> lastNode = tail;
        Node<E> newNode = new Node<>(lastNode, item, null);
        tail = newNode;
        if (isEmpty()) {
            head = newNode;
        } else {
            lastNode.next = newNode;
        }
        size++;
    }

    /**
     * It will add item in O(n/2) time.
     *
     * @param index position for the item to be added at a specific position
     * @param item  the element to be add
     */
    private void linkBefore(int index, E item) {
        if (index == 0) {
            if (size == 0) {
                linkLast(item);
            } else {
                Node<E> headNode = head;
                Node<E> newNode = new Node<>(null, item, headNode);
                headNode.prev = newNode;
                head = newNode;
            }
        } else {
            Node<E> prevNode = prevNode(index);
            Node<E> nextNode = prevNode.next;

            Node<E> newNode = new Node<>(prevNode, item, nextNode);
            prevNode.next = newNode;
            nextNode.prev = newNode;
        }
        size++;
    }

    public void add(int index, E item) {
        checkPositionIndex(index);
        if (index == size) {
            linkLast(item);
        } else {
            linkBefore(index, item);
        }
    }

    /**
     * @return it will return the prevNode in O(n/2) from the specific index position
     */
    private Node<E> prevNode(int index) {
        Node<E> node;
        if (index < (size >> 1)) {
            node = head;
            for (int i = 0; i < index - 1; i++) {
                node = node.next;
            }
        } else {
            node = tail;
            for (int i = size; i > index; i--) {
                node = node.prev;
            }
        }
        return node;
    }

    public void remove(int index) {
        checkPositionIndex(index);
        if (index < (size >> 1)) {
            unlinkBefore(index);
        } else {
            unlinkLast(index);
        }
    }

    private void unlinkBefore(int index) {

    }

    private void unlinkLast(int index) {

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

    public void printAll() {
        for (Object e : getAll()) {
            System.out.print(e + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();

        dll.add(1);
        dll.add(5);
        dll.add(3);
        dll.add(6);
        dll.add(8);
        dll.add(10);
        dll.add(15);

        dll.printAll();
        System.out.println("\nItem at index 3 is " + dll.node(3).item + " ");

        dll.reverse();
        System.out.println("\nAfter Reverse : ");
        dll.printAll();

        System.out.println("\nAfter adding two items : ");
        dll.add(20);
        dll.add(25);
        dll.printAll();

        dll.remove(15);
        System.out.println("\nAfter removing 15 from the list");
        dll.printAll();

        dll.add(2, 11);
        System.out.println("\nAdding 11 at position 2 : ");
        dll.printAll();
    }
}
