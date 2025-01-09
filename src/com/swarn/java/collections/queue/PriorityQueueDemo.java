package com.swarn.java.collections.queue;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int[] arr = {7, 1, 2, 3, 6, 5, 4};

        for (int item : arr) {
            pq.add(item);
        }
        System.out.println(pq);
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
        HashMap<Integer, Integer> map = new HashMap();
        map.put(0, 1);
        map.put(1, 3);
        map.put(2, 4);
        PriorityQueue<Map.Entry<Integer, Integer>> pq1 = new PriorityQueue<>(
                (a, b) -> b.getValue().compareTo(a.getValue())
        );

        pq1.addAll(map.entrySet());
    }
}
