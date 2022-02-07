package com.datastructure.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Swarn Singh.
 */


public class ReversePartialLinkedList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void getAll(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            head = head.next;
            if (head != null) {
                System.out.print(" -> ");
            }
        }
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        // Empty list
        if (head == null) {
            return null;
        }
        ListNode leftNode = head, prevNode = null, rightNode = head, rightNextNode = null;
        for (int i = 1; i <= n; i++) {
            if (m > i) {
                prevNode = leftNode;
                leftNode = leftNode.next;
            }
            if (n > i) {
                rightNode = rightNode.next;
            }
            if (n == i) {
                rightNextNode = rightNode.next;
                rightNode.next = null;
            }
        }

        ListNode leftHead = leftNode;
        ListNode current = leftNode;
        ListNode prev = null;
        while (current != null) {
            ListNode node = current.next;
            current.next = prev;
            prev = current;
            current = node;
            leftHead = prev;
        }

        if (prevNode != null) {
            prevNode.next = leftHead;
        }
        if (rightNextNode != null) {
            if (m ==1) {
                leftNode = rightNextNode;
            } else {
                leftNode.next = rightNextNode;
            }
        } else {
            if (m == 1) {
                head = rightNode;
            } else {
                head.next = rightNode;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(4);
        list.add(6);
        list.add(8);
        list.add(10);
        list.add(12);

        ListNode head = null;
        ListNode currentNode = null;
        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                head = new ListNode(list.get(i));
                currentNode = head;
            } else {
                ListNode node = new ListNode(list.get(i));
                currentNode.next = node;
                currentNode = node;
            }
        }
        getAll(head);
        System.out.println();
        getAll(reverseBetween(head, 1, 3));
    }
}
