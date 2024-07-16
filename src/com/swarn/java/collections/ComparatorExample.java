package com.swarn.java.collections;

import java.util.*;

/**
 * @author Swarn Singh.
 */
public class ComparatorExample {

    public static void main(String[] args) {
        List<Student> al = new ArrayList<>();
        al.add(new Student(102, "Vijay", 23));
        al.add(new Student(102, "Jay", 23));
        al.add(new Student(107, "Ajay", 27));
        al.add(new Student(105, "Jai", 21));
        al.add(new Student(105, "Aman", 21));

        System.out.println("\nBefore Sorting\n");
        al.forEach(st -> System.out.println(st));

        System.out.println("\nAfter Age Sorting\n");

        Collections.sort(al, new AgeComparator());
        al.forEach(st -> System.out.println(st));

        System.out.println("\nAfter Name Sorting\n");

        Collections.sort(al, new NameComparator());
        al.forEach(st -> System.out.println(st));

        System.out.println("\nAfter Roll No. Sorting\n");

        Collections.sort(al, Comparator.comparing(Student::getRollNo));
        al.forEach(st -> System.out.println(st));

        // Here set will add the unique roll no. student only.
        Set<Student> set = new LinkedHashSet<>();
        set.addAll(al);

        System.out.println(set);
    }
}

class AgeComparator implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        if (s1.getAge() == s2.getAge())
            return 0;
        else if (s1.getAge() > s2.getAge())
            return 1;
        else
            return -1;
    }
}

class NameComparator implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        return s1.getName().compareTo(s2.getName());
    }
}

