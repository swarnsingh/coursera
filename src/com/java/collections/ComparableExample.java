package com.java.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Swarn Singh.
 */
public class ComparableExample {

    static class Student implements Comparable<Student> {
        int rollNo;
        String name;
        int age;

        Student(int rollNo, String name, int age) {
            this.rollNo = rollNo;
            this.name = name;
            this.age = age;
        }

        public int compareTo(Student st) {
            if (age == st.age)
                return 0;
            else if (age > st.age)
                return 1;
            else
                return -1;
        }
    }

    public static void main(String args[]) {
        List<Student> al = new ArrayList<>();
        al.add(new Student(101, "Vijay", 23));
        al.add(new Student(106, "Ajay", 27));
        al.add(new Student(105, "Jai", 21));

        Collections.sort(al);
        al.forEach(st -> System.out.println(st.rollNo + " " + st.name + " " + st.age));
    }
}
