package com.swarn.solid;


class Parent {
    public int getPrice() throws Exception {
        return Integer.parseInt("1");
    }
}

class Child extends Parent {
    public int getPrice() throws NumberFormatException {
        return Integer.parseInt("2");
    }
}
public class LiskovSubstitutionPrinciple {
    public static void main(String[] args) throws Exception {
        Parent obj1 = new Parent();
        System.out.println(obj1.getPrice());

        Parent obj2 = new Child();
        System.out.println(obj2.getPrice());
    }
}
