package com.swarn;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

public class Solution {

    static class A {

        A() {
            System.out.println("A constructor");
        }

        protected void print() throws Exception  {
            System.out.println("Print A");
        }

        public void printA() {
            System.out.println("Print A method");
        }
    }

    static class B extends A {
        B() {
            System.out.println("B constructor");
        }

        public void print() throws Exception {
            System.out.println("Print B");
        }

        public void printB() {
            System.out.println("Print B method");
        }
    }

    static class C extends B {
        C() {
            super();
            System.out.println("C constructor");
        }

        public void print() throws Exception {
            System.out.println("Print C");
        }

        public void printC() {
            System.out.println("Print C method");
        }
    }

    static void printType(float param,
                          double param2) {
        System.out.println("float-double");
    }
    static void printType(double param,
                          float param2) {
        System.out.println("double-float");
    }

    public static void main(String[] args) throws Exception {

        try {
            throw new P();
        } catch(P p) {
            System.out.println("First");
        } catch(Exception e) {
            System.out.println("Second");
        }


        int arrCount = 5;

        printType(1.0f, 2.0d);

        List<String> arrTemp = new ArrayList<>();
        arrTemp.add("-5");
        arrTemp.add("4");
        arrTemp.add("-2");
        arrTemp.add("3");
        arrTemp.add("1");

        Object obj;

        List<Integer> arr = arrTemp.stream()
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int k = Integer.parseInt("30");

        //System.out.println(minHealth(arr));

        A a = new C();
        a.print();
        a.printA();
        ((C) a).printB();
        ((C) a).printC();

        a = new B();
        a.print();
        ((B) a).printB();
        a.printA();

         long l = 20L;
         int i = (int) l;

         System.out.println(i);

         double d = 20.0D;
         i = (int) d;

         System.out.println(i);

        ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("JavaScript");

        engine.eval("value = 10");
        Boolean greaterThan5 = (Boolean) engine.eval("value > 5");
        Boolean lessThan5 = (Boolean) engine.eval("value < 5");

        System.out.println("10 > 5? " + greaterThan5); // true
        System.out.println("10 < 5? " + lessThan5); // false


        Map<DataKey, Integer> hm = getAllData();

        // Hashcode will be different if not override
        DataKey dk = new DataKey();
        dk.setId(1);
        dk.setName("Pankaj");
        System.out.println("Main "+dk.hashCode());

        Integer value = hm.get(dk);

        System.out.println("Value : "+value);

        Map<Character, Integer> map = new HashMap<>();
        map.put('c',1);

        System.out.println(map.get('c'));

    }

    private static Map<DataKey, Integer> getAllData() {
        Map<DataKey, Integer> hm = new HashMap<>();

        // Hashcode will be different if not override
        DataKey dk = new DataKey();
        dk.setId(1);
        dk.setName("Pankaj");
        System.out.println("Method : "+dk.hashCode());

        hm.put(dk, 10);

        return hm;
    }


    static String findNumber(List<Integer> arr, int k) {
        return arr.contains(k) ? "YES" : "NO";
    }

    private synchronized void method(int i) {
        synchronized (this) {

        }
    }

    public static long minHealth(List<Integer> dungeon) {

        int minHealth = 0;
        int temp = 0;
        for (int i : dungeon) {
            int value = temp + i;
            if (value <= 0) {
                minHealth += Math.abs(i);
                temp = minHealth + i;
            } else {
                temp += value;
            }
        }
        return minHealth + 1;
    }

    static List<Integer> oddNumbers(int l, int r) {

        List<Integer> list = new ArrayList<>();
        for (int i = l; l >= r; i++) {
            if (i % 2 != 0) {
                list.add(i);
            }
        }
        return list;
    }

    static class DataKey {

        private String name;
        private int id;

        // getter and setter methods

        @Override
        public String toString() {
            return "DataKey [name=" + name + ", id=" + id + "]";
        }

        public void setId(int i) {
            id = i;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + id;
            result = prime * result + ((name == null) ? 0 : name.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            DataKey other = (DataKey) obj;
            if (id != other.id)
                return false;
            if (name == null) {
                return other.name == null;
            } else return name.equals(other.name);
        }
    }

    static class P extends Exception {

    }

    static class Q extends P {

    }
}
