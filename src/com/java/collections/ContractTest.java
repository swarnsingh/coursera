package com.java.collections;

import java.util.*;

/**
 * @author Swarn Singh.
 */
public class ContractTest {

    public static void main(String[] args) {
        Map<EmployeeKey, String> cache = loadEmpCache();

        EmployeeKey lookUpKey = new EmployeeKey("100", "10101984");

        String empName = cache.get(lookUpKey);

        System.out.println(empName);

        EmployeeKey ek1 = new EmployeeKey("100", "10101984");
        EmployeeKey ek2 = new EmployeeKey("101", "11101974");
        EmployeeKey ek3 = new EmployeeKey("102", "12101994");
        EmployeeKey ek4 = new EmployeeKey("100", "10101984");
        EmployeeKey ek5 = new EmployeeKey("101", "11101974");
        EmployeeKey ek6 = new EmployeeKey("103", "12101994");

        Set<EmployeeKey> set = new HashSet<>();
        set.add(ek1);
        set.add(ek2);
        set.add(ek3);
        set.add(ek4);
        set.add(ek5);
        set.add(ek6);

        set.forEach(System.out::println);
    }

    static Map<EmployeeKey, String> loadEmpCache() {
        EmployeeKey ek1 = new EmployeeKey("100", "10101984");
        EmployeeKey ek2 = new EmployeeKey("101", "11101974");
        EmployeeKey ek3 = new EmployeeKey("102", "12101994");

        Map<EmployeeKey, String> cache = new HashMap<>();
        cache.put(ek1, "Bob");
        cache.put(ek2, "Steve");
        cache.put(ek3, "Robert");

        return cache;
    }
}

class EmployeeKey {
    String empId;
    String dob;

    public EmployeeKey(String empId, String dob) {
        this.empId = empId;
        this.dob = dob;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeKey that = (EmployeeKey) o;
        return Objects.equals(empId, that.empId) &&
                Objects.equals(dob, that.dob);
    }

    @Override
    public String toString() {
        return "EmployeeKey{" +
                "empId='" + empId + '\'' +
                ", dob='" + dob + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(empId, dob);
    }
}
