package com.java.multithreading;

/**
 * @author Swarn Singh.
 */
public class MultiThreadingDemo implements Runnable {

    private volatile int count = 0;

    public static void main(String[] args) {
        MultiThreadingDemo multiThreadingDemo = new MultiThreadingDemo();

        Thread t1 = new Thread(multiThreadingDemo);
        t1.start();

        Thread t2 = new Thread(multiThreadingDemo);
        t2.start();

        Thread t3 = new Thread(multiThreadingDemo);
        t3.start();

        Thread t4 = new Thread(multiThreadingDemo);
        t4.start();

    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            count = count + 1;
        }
        // Here final count value should be 40,000 but it is not guaranteed even you use volatile variable
        System.out.println("Current Thread : " + Thread.currentThread().getId() + " Count : " + count);
    }
}
