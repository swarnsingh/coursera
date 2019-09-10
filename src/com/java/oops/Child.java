package com.java.oops;

/**
 * @author Swarn Singh.
 */
public class Child extends Parent {

    public double area(int value) {
        return (22 / 7) * (value * value);
    }

    public Child getObj() {
        return new Child();
    }

    public static void main(String[] args) {
        Parent p = new Parent();
        System.out.println(p.area(5));

        p = new Child();
        System.out.println(p.area(5));
        p.show(10);

        Child c = new Child();
        c.show(12);
        System.out.println(c.area(5));

    }
}
