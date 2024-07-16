package com.swarn.java.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Swarn Singh.
 */
public class ComparableExample {

    public static void main(String[] args) {
        List<Student> al = new ArrayList<>();
        al.add(new Student(101, "Vijay", 23));
        al.add(new Student(106, "Ajay", 27));
        al.add(new Student(105, "Jai", 21));


        Collections.sort(al); // Comparable sorting based on the Comparable Interface
        System.out.println("\nSort By comparable : \n" + al);

        // al.sort((a,b) -> a.name.compareTo(b.name));
        // al.sort(Comparator.comparing(Student::getName));
        al.sort(Comparator.comparing(student -> student.getName())); // above both line produce the same result

        System.out.println("\nSort By Name : \n" + al);

        al.sort(Comparator.comparing(Student::getName).reversed()); // For Descending Order
        System.out.println("\nSort By Name in Descending Order : \n" + al);
    }
}
