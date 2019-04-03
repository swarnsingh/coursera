package com.java.multithreading;

/**
 * @author Swarn Singh.
 */
public class DeadlockExample {

    public static void main(String[] args) {
        final String resource1 = "Swarn Singh";
        final String resource2 = "Inder Singh";

        // t1 tries to lock resource1 then resource2
        Thread t1 = new Thread(() -> {
            synchronized (resource1) {
                System.out.println("Thread 1: locked resource 1 : Thread id - " + Thread.currentThread().getId());

                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                }

                synchronized (resource2) {
                    System.out.println("Thread 1: locked resource 2 : Thread id - " + Thread.currentThread().getId());
                }
            }
        });

        // t2 tries to lock resource2 then resource1
        Thread t2 = new Thread(() -> {
            synchronized (resource2) {
                System.out.println("Thread 2: locked resource 2 : Thread id - " + Thread.currentThread().getId());

                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                }

                synchronized (resource1) {
                    System.out.println("Thread 2: locked resource 1 : Thread id - " + Thread.currentThread().getId());
                }
            }
        });

        t1.start();
        t2.start();
    }
}
