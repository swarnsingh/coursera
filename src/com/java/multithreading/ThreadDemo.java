package com.java.multithreading;

/**
 * @author Swarn Singh.
 */
public class ThreadDemo implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i < 5; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            System.out.println(i + " Current Thread Id : " + Thread.currentThread().getId());
        }
    }

    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo();
        System.out.println("Main Thread id : " + Thread.currentThread().getId());

        Thread t1 = new Thread(threadDemo);
        Thread t2 = new Thread(threadDemo);
        Thread t3 = new Thread(threadDemo);

        t1.start();
        try {
            t1.join();
        } catch (Exception e) {
            System.out.println(e);
        }

        t2.start();
        t3.start();

        System.out.println("T1 Id : " + t1.getId());
        System.out.println("T2 Id : " + t2.getId());
        System.out.println("T3 Id : " + t3.getId());
    }
}
