package com.java.multithreading;

import java.util.concurrent.Executors;

/**
 * @author Swarn Singh.
 */
public class ThreadPool {
    private static class WorkerThread implements Runnable {
        private String message;

        public WorkerThread(String s) {
            this.message = s;
        }

        public void run() {
            System.out.println(Thread.currentThread().getName() + " (Start) message = " + message);
            processMessage();//call processMessage method that sleeps the thread for 2 seconds
            System.out.println(Thread.currentThread().getName() + " (End)");//prints thread name
        }

        private void processMessage() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        var executor = Executors.newFixedThreadPool(5);//creating a pool of 5 threads
        for (int i = 0; i < 10; i++) {
            var worker = new WorkerThread("" + i);
            executor.execute(worker);//calling execute method of ExecutorService
        }
        int ans[] = new int[5];
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("Finished all threads");
        String str = "mouse";
        System.out.println(str.substring(0, 2));
    }
}
