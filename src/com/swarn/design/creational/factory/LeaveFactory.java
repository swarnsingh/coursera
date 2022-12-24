package com.swarn.design.creational.factory;

/**
 * @author Swarn Singh.
 */
public class LeaveFactory {

    public static ILeave getLeave(LeaveType leaveType) {
        switch (leaveType) {
            case CASUAL_LEAVE:
                return new CasualLeave();
            case COMPLIMENTARY_LEAVE:
                return new ComplimentaryLeave();
            default:
                return null;
        }
    }
}
