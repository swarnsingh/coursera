package com.swarn.java.collections.queue;

import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] arr = {14, 5, 61, 17, 11, 12, 31};

        for (int item : arr) {
            pq.add(item);
        }

        System.out.println(pq);

        System.out.println();

        pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int item : arr) {
            pq.add(item);
        }
        System.out.println(pq);
    }
}
