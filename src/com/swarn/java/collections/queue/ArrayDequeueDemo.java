package com.swarn.java.collections.queue;

import java.util.*;

/**
 * Resizable-array implementation of the Deque interface. Array deques have no capacity restrictions;
 * they grow as necessary to support usage. They are not thread-safe; in the absence of external synchronization,
 * they do not support concurrent access by multiple threads. Null elements are prohibited. This class is likely
 * to be faster than Stack when used as a stack, and faster than LinkedList when used as a queue.
 *
 * @author Swarn Singh.
 */
public class ArrayDequeueDemo {

    public static void main(String[] args) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.offer(23);
        deque.offer(12);
        deque.offer(45);
        deque.offer(26);
        deque.add(20);

        System.out.println(deque);

        System.out.println(deque.peek());
        System.out.println(deque.peekFirst());
        System.out.println(deque.peekLast());

        System.out.println("poll() - " + deque.poll());
        System.out.println(deque);

        System.out.println("pollLast() - " + deque.pollLast());
        System.out.println(deque);
    }
}
