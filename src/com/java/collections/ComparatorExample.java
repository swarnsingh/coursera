package com.java.collections;

import java.util.*;

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

        List<String> list = new ArrayList<>();

        list.add("123");
        list.add("456");
        list.add("789");

        Iterator<String> iterator = list.iterator();

        while(iterator.hasNext()) {
            String value = iterator.next();

            if(value.equals("456")){
               // list.add("999"); // It will throw java.util.ConcurrentModificationException
                iterator.remove();
            }
        }

        System.out.println();
        list.forEach(System.out::println);
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

