package com.java.collections.arraylist;

import com.java.collections.Designation;
import com.java.collections.Employee;
import com.java.collections.EmployeeCreator;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Swarn Singh.
 */
public class ArrayListDemo {

    public static void main(String[] args) {
        var list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 13, 4, 10);

        list.stream()
                .filter(item -> item % 2 == 0)
                .distinct()
                .map(String::valueOf)
                .forEach(System.out::println);

        System.out.println();

        var employees = EmployeeCreator.getEmployees();

        // Emp name by comma separator
        String names = employees.stream()
                .filter(employee -> employee.designation().equals(Designation.SR_SOFTWARE_ENGINEER))
                .sorted(Comparator.comparingInt(Employee::salary).reversed())
                .limit(3)
                .map(Employee::name)
                .collect(Collectors.joining(", "));

        System.out.println(names);

        System.out.println("\n\nEmployees by Designation --------");

        // Group by Designation
        Map<Designation, List<Employee>> empByDesignation
                = employees.stream()
                .collect(Collectors.groupingBy(Employee::designation));

        empByDesignation.forEach((key, value) -> {
            System.out.println();
            value.forEach(employee -> {
                System.out.println(employee.name() + " : " + employee.designation().position);
            });
        });

        System.out.println("\n\nEmployees Count by Designation -------------");

        // Count Employees by Designation
        Map<Designation, Long> designationCounts
                = employees.stream()
                .collect(Collectors.groupingBy(Employee::designation, Collectors.counting()));

        designationCounts.forEach((key, value) -> System.out.println(key + " : " + value));

        Hashtable<Integer,String> hm= new Hashtable<>();

        hm.put(100,"Amit");
        hm.put(102,"Ravi");
        hm.put(101,"Vijay");
        hm.put(103,"Rahul");

        hm.forEach((key, value) -> System.out.println(key + " : " + value));
    }
}
