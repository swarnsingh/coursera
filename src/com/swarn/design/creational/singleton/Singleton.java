package com.swarn.design.creational.singleton;

/**
 * @author Swarn Singh.
 */
public class Singleton {

    /**
     * The solution is to use the volatile keyword, which guarantees that any read/write operation of a variable
     * shared by many threads would be atomic and not cached.
     */
    private static volatile Singleton instance;

    private Singleton() {
    }

    /**
     * In a multithreading environment, if two or more threads are executing this method in parallel,
     * there's a significant risk of ending up with multiple instances of the class.
     * One solution is to synchronize the method so only one thread at a time can access it.
     *
     * The problem with this is that strictly speaking, is not very efficient.
     * We only need synchronization the first time, when the instance is created, not every single time the method is called.
     *
     * An improvement is to lock only the portion of the code that creates the instance. For this to work properly,
     * we have to double check if the instance is null, one without locking (to check if the instance is already created),
     * and then another one inside a synchronized block (to safely create the instance).
     *
     * @return Singleton
     */
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
