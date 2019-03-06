package com.java.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Swarn Singh.
 */
public class ComparatorExample {

    public static void main(String args[]) {
        List<Student> al = new ArrayList<>();
        al.add(new Student(102, "Vijay", 23));
        al.add(new Student(107, "Ajay", 27));
        al.add(new Student(105, "Jai", 21));

        //Collections.sort(al);
        System.out.println("\n Before Sorting\n");
        al.forEach(st -> System.out.println(st.rollNo + " " + st.name + " " + st.age));

        System.out.println("\n After Age Sorting\n");

        Collections.sort(al, new AgeComparator());
        al.forEach(st -> System.out.println(st.rollNo + " " + st.name + " " + st.age));

        System.out.println("\n After Name Sorting\n");

        Collections.sort(al, new NameComparator());
        al.forEach(st -> System.out.println(st.rollNo + " " + st.name + " " + st.age));

        System.out.println("\n After Roll No. Sorting\n");

        Collections.sort(al, Comparator.comparing(Student::getRollNo));
        al.forEach(st -> System.out.println(st.rollNo + " " + st.name + " " + st.age));
    }
}

class Student {
    int rollNo;
    String name;
    int age;

    Student(int rollNo, String name, int age) {
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

class AgeComparator implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        if (s1.age == s2.age)
            return 0;
        else if (s1.age > s2.age)
            return 1;
        else
            return -1;
    }
}


class NameComparator implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        return s1.name.compareTo(s2.name);
    }
}

