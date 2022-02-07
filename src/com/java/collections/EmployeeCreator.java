package com.java.collections;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Swarn Singh.
 */
public class EmployeeCreator {
    public static List<Employee> getEmployees() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Aman Sharma", Designation.SOFTWARE_ENGINEER, 50_000));
        employees.add(new Employee(2, "Ankit Fadia", Designation.SR_SOFTWARE_ENGINEER, 80_000));
        employees.add(new Employee(3, "Anubhav Verma", Designation.JR_SOFTWARE_ENGINEER, 30_000));
        employees.add(new Employee(4, "Aman Singh", Designation.SOFTWARE_ENGINEER, 55_000));
        employees.add(new Employee(5, "Amit Garg", Designation.SR_SOFTWARE_ENGINEER, 90_000));
        employees.add(new Employee(6, "Tony Sharma", Designation.SOFTWARE_ENGINEER, 50_000));
        employees.add(new Employee(7, "Swarn Singh", Designation.SR_SOFTWARE_ENGINEER, 100_000));
        employees.add(new Employee(8, "Vijay sharma", Designation.SR_SOFTWARE_ENGINEER, 95_000));
        employees.add(new Employee(9, "Tony Sharma", Designation.SOFTWARE_ENGINEER, 50_000));
        employees.add(new Employee(1, "Swarn Singh", Designation.SR_SOFTWARE_ENGINEER, 100_000));
        return employees;
    }
}
