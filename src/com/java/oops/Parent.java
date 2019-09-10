package com.java.oops;

/**
 * @author Swarn Singh.
 */
public class Parent {
    public double area(int value) {
       return value * value;
    }

    public Parent getObj() {
        return new Parent();
    }

    public void show(int x) {
        System.out.println(x);
    }
}
