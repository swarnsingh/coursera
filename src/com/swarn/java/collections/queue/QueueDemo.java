package com.swarn.java.collections.queue;

import com.swarn.java.collections.Employee;
import com.swarn.java.collections.EmployeeCreator;

import java.math.BigInteger;
import java.util.*;

/**
 * PriorityQueue maintains natural order when items remove from the queue.
 */

/**
 * @author Swarn Singh.
 */
public class QueueDemo {

    private static void printQueue(Queue queue) {
        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }
    }

    public static void main(String[] args) {
        /**
         * It will take priority to the Max salary using Max-Heap
         * For Custom Object Collections.reverseOrder() will not work because
         * Employee class needs to implement Comparable interface otherwise it will
         * throw ClassCastException
         */
        Queue<Employee> queue = new PriorityQueue<>(((o1, o2) -> o2.salary() - o1.salary()));
        queue.addAll(EmployeeCreator.getEmployees());
        printQueue(queue);

        Queue<Integer> q11 = new LinkedList<>();

        List<Integer> numbers = Arrays.asList(3, 2, 3, 1, 2, 4, 5, 5, 6);
        int k = 4;
        System.out.println("\nKth Largest Number : " + findKthLargestNo(numbers, k));

        Queue<Integer> q = new PriorityQueue<>();
        for (int i : numbers) {
            q.add(i);
        }

        printQueue(q);

        String[] nums = new String[]{
                "683339452288515879", "7846081062003424420", "4805719838", "4840666580043", "83598933472122816064",
                "522940572025909479", "615832818268861533", "65439878015", "499305616484085", "97704358112880133",
                "23861207501102", "919346676", "60618091901581", "5914766072", "426842450882100996", "528",
                "914353682223943129", "97", "241413975523149135", "8594929955620533", "55257775478129",
                "5110809", "7930848872563942788", "758", "4", "38272299275037314530", "9567700", "28449892665",
                "2846386557790827231", "53222591365177739", "703029", "3280920242869904137", "87236929298425799136",
                "3103886291279"};

        System.out.println("\nKth Largest Number : " + kthLargestNumber(nums, k));

        // By default, Priority Queue follows Min-Heap, Here it will work as Max-Heap
        Queue<Integer> queue1 = new PriorityQueue<>(Collections.reverseOrder());
        queue1.offer(5);
        queue1.offer(7);
        queue1.offer(1);
        queue1.offer(10);

        printQueue(queue1);
    }

    public static int findKthLargestNo(List<Integer> numbers, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : numbers) {
            pq.add(i);
        }
        int count = 1;
        int item = numbers.get(0);
        while (!pq.isEmpty() && count <= k) {
            if (k == count) {
                item = pq.poll();
                break;
            } else {
                count++;
                pq.poll();
            }
        }
        return item;
    }

    public static int findKthLargestNumber(List<Integer> numbers, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            pq.add(numbers.get(i));
        }
        for (int i = k; i < numbers.size(); i++) {
            if (pq.peek() != null && pq.peek() < numbers.get(i)) {
                pq.poll();
                pq.add(numbers.get(i));
            }
        }
        return pq.peek();
    }

    public static String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<BigInteger> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            pq.add(new BigInteger(nums[i]));
        }

        for (int i = k; i < nums.length; i++) {
            if (pq.peek() != null && pq.peek().compareTo(new BigInteger(nums[i])) < 0) {
                pq.poll();
                pq.add(new BigInteger(nums[i]));
            }
        }
        return String.valueOf(pq.peek());
    }
}
