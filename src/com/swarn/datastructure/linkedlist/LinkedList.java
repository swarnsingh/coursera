package com.swarn.datastructure.linkedlist;

import java.util.*;

/**
 * @author Swarn Singh.
 */
public class LinkedList<E> {
    private int size = 0;
    private Node<E> head;
    private Node<E> tail;

    private static class Node<E> {
        private Node<E> next;
        E item;

        Node(E item) {
            this.item = item;
        }
    }

    public boolean add(E item) {
        linkLast(item);
        return true;
    }

    public void add(int index, E item) {
        checkPositionIndex(index);
        if (index == size) {
            linkLast(item);
        } else {
            linkBefore(index, item);
        }
    }

    private void linkLast(E item) {
        Node<E> node = tail;
        if (node == null) {
            node = new Node<>(item);
            tail = node;
            head = node;
        } else {
            node = new Node<>(item);
            tail.next = node;
            tail = node;
        }
        size++;
    }

    private void linkBefore(int index, E item) {
        if (index == 0) {
            if (size == 0) {
                linkLast(item);
            } else {
                Node<E> node = new Node<>(item);
                node.next = head;
                head = node;
            }
        } else {
            Node<E> node = new Node<>(item);
            Node<E> tempNode = prevNode(index);
            node.next = tempNode.next;
            tempNode.next = node;
        }
        size++;
    }

    private Node<E> prevNode(int index) {
        Node<E> node = head;
        for (int i = 0; i < index - 1; i++) {
            node = node.next;
        }
        return node;
    }

    /**
     * Tells if the argument is the index of an existing element.
     */
    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    /**
     * Tells if the argument is the index of a valid position for an
     * iterator or an add operation.
     */
    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index)) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    public void remove() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        unlinkLast();
    }

    public void remove(int index) {
        checkElementIndex(index);

        if (index == size - 1) {
            unlinkLast();
        } else {
            unlinkBefore(index);
        }
    }

    private void unlinkBefore(int index) {
        if (index == 0) {
            head = head.next;
        } else {
            Node<E> node = prevNode(index);
            Node<E> tempNode = node.next;
            node.next = tempNode.next;
        }
        size--;
    }

    private void unlinkLast() {
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            Node<E> node = prevNode(size - 1);
            node.next = null;
            tail = node;
        }
        size--;
    }

    public void reverse() {
        Node<E> current = head;
        Node<E> prevNode = null;

        while (current != null) {
            Node<E> node = current.next;

            current.next = prevNode;
            prevNode = current;
            current = node;
            head = prevNode;
        }
    }

    public Object[] getAll() {
        Object[] result = new Object[size];
        int i = 0;
        for (Node<E> x = head; x != null; x = x.next)
            result[i++] = x.item;
        return result;
    }

    public boolean isPalindrome() {
        Stack stack = new Stack();
        int i = 0;
        for (Node<E> x = head; x != null; x = x.next, i++) {
            if (i < (size / 2)) {
                stack.push(x.item);
            } else if (size % 2 == 0 || i != size / 2) {
                Object item = stack.pop();
                if (item != x.item) {
                    return false;
                }
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        if (map.containsKey(1)) {

        } else {
            
        }
        map.put(1,1);
        LinkedList l = new LinkedList();
        l.add(1);
        l.add(4);
        l.add(4);
        l.add(1);

        System.out.print("\nLinked List with Integers : ");
        for (Object e : l.getAll()) {
            System.out.print(e + " ");
        }

        System.out.println("\nIs Linked list is palindrome : " + l.isPalindrome());

        l.add(4, 2);

        System.out.println();
        System.out.print("After adding at last position : ");
        for (Object e : l.getAll()) {
            System.out.print(e + " ");
        }

        l.remove();
        l.remove(0);

        System.out.println();
        System.out.print("After remove 0 & last position : ");

        for (Object e : l.getAll()) {
            System.out.print(e + " ");
        }

        l.reverse();
        System.out.println();
        System.out.print("Reverse order : ");

        for (Object e : l.getAll()) {
            System.out.print(e + " ");
        }

        LinkedList<Character> l1 = new LinkedList<>();
        l1.add('d');
        l1.add('a');
        l1.add('d');

        System.out.print("\nLinked List with Characters : ");
        for (Object e : l1.getAll()) {
            System.out.print(e + " ");
        }

        System.out.println("\nIs Linked list is palindrome : " + l1.isPalindrome());
    }
}
