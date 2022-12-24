package com.swarn.java.multithreading;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Swarn Singh.
 */
public class ThreadLocalExample implements Runnable {

    // Atomic integer containing the next thread ID to be assigned
    private static final AtomicInteger nextId = new AtomicInteger(0);

    // Thread local variable containing each thread's ID
    private static final ThreadLocal<Integer> threadId = ThreadLocal.withInitial(nextId::getAndIncrement);

    // Returns the current thread's unique ID, assigning it if necessary
    public int getThreadId() {
        return threadId.get();
    }

    // Returns the current thread's starting timestamp
    private static final ThreadLocal<Date> startDate = ThreadLocal.withInitial(Date::new);

    @Override
    public synchronized void run() {
        System.out.printf("Starting Thread: %s : %s\n", getThreadId(), startDate.get());
        try {
            TimeUnit.SECONDS.sleep((int) Math.rint(Math.random() * 10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Thread Finished: %s : %s\n", getThreadId(), startDate.get()+"\n");
    }

    public static void main(String[] args) {
        ThreadLocalExample threadLocalExample = new ThreadLocalExample();

        new Thread(threadLocalExample).start();

        new Thread(threadLocalExample).start();

        new Thread(threadLocalExample).start();
    }
}

