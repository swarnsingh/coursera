package com.swarn.design.creational.factory;

import java.util.Date;

/**
 * @author Swarn Singh.
 */
public class Leave {
    private int leaveId;

    private Date fromDate;

    private Date toDate;

    private LeaveType leaveType;

    private String leaveReason;

    private PartOfDay partOfDay;

    public int getLeaveId() {
        return leaveId;
    }

    public void setLeaveId(int leaveId) {
        this.leaveId = leaveId;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public LeaveType getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(LeaveType leaveType) {
        this.leaveType = leaveType;
    }

    public String getLeaveReason() {
        return leaveReason;
    }

    public void setLeaveReason(String leaveReason) {
        this.leaveReason = leaveReason;
    }

    public PartOfDay getPartOfDay() {
        return partOfDay;
    }

    public void setPartOfDay(PartOfDay partOfDay) {
        this.partOfDay = partOfDay;
    }

    @Override
    public String toString() {
        return "Leave{" +
                "leaveId=" + leaveId +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", leaveType=" + leaveType +
                ", leaveReason='" + leaveReason + '\'' +
                ", partOfDay=" + partOfDay +
                '}';
    }
}
