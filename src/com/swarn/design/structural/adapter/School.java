package com.swarn.design.structural.adapter;

/**
 * @author Swarn Singh.
 */
public class School {

    public static void main(String[] args) {
        Assignment assignment = new Assignment();
        PenAdapter penAdapter = new PenAdapter();
        assignment.setPen(penAdapter);
        assignment.writeAssignment("My Assignment");
    }
}
