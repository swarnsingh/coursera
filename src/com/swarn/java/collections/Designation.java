package com.swarn.java.collections;

/**
 * @author Swarn Singh.
 */
public enum Designation {

    JR_SOFTWARE_ENGINEER("Jr. Software Engineer"),
    SOFTWARE_ENGINEER("Software Engineer"),
    SR_SOFTWARE_ENGINEER("Sr. Software Engineer");

    public final String position;

    Designation(String position) {
        this.position = position;
    }

    public static Designation valueOfDesignation(String position) {
        for (Designation designation : values()) {
            if (designation.position.equals(position)) {
                return designation;
            }
        }
        return null;
    }
}
