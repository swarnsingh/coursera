package com.swarn.java.collections.set;

import com.swarn.java.collections.Employee;
import com.swarn.java.collections.EmployeeCreator;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Swarn Singh.
 */
public class SetDemo {

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>(Arrays.asList(6, 7, 5, 6, 7, 9, 1, 2, 3, 1, 5, 3, 5));
       // set.forEach(System.out::println);

        var values = set.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println(values);

        Set<String> set1 = new TreeSet<>(Arrays.asList("Vijay", "Swarn", "Aman", "Ankit", "Balram", "Aman"));
        System.out.println(set1);

        List<Employee> employees = EmployeeCreator.getEmployees();

        System.out.println("\n-------------------------------------\nAll Employees List");
        var obj1 = new HashSet<>(employees);
        obj1.forEach(System.out::println);

        System.out.println("\n-------------------------------------\nSort by Name");
        var obj2 = new TreeSet<>(Comparator.comparing(Employee::name));
        obj2.addAll(employees);
        obj2.forEach(System.out::println);

        System.out.println("\n-------------------------------------\nAll Employees List with insertion order");
        var obj3 = new LinkedHashSet<>(employees);
        obj3.forEach(System.out::println);
    }
}
