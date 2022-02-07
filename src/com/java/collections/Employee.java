package com.java.collections;

import java.util.Objects;

/**
 * @author Swarn Singh.
 */
public record Employee(int id, String name, Designation designation, int salary) {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}