package com.swarn.design.creational.factory;

import java.util.Date;

/**
 * @author Swarn Singh.
 */
public class LeaveTesting {

    public static Leave getLeave() {
        Leave leave = new Leave();
        leave.setFromDate(new Date());
        leave.setToDate(new Date());
        leave.setLeaveReason("Need to attend marriage");
        leave.setLeaveType(LeaveType.CASUAL_LEAVE);
        leave.setPartOfDay(PartOfDay.FULL_DAY);

        return leave;
    }

    public static void main(String[] args) {
        Leave leave = getLeave();
        ILeave iLeave = LeaveFactory.getLeave(leave.getLeaveType());
        iLeave.applyLeave(1, leave);
        iLeave.checkHistory(1);
    }
}
