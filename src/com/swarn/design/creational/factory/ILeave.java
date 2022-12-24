package com.swarn.design.creational.factory;

/**
 * @author Swarn Singh.
 */
public interface ILeave {
    void applyLeave(int userId, Leave leave);

    void editLeave(int userId, Leave leave);

    void withdrawLeave(int userId, Leave leave);

    void checkBalance(int userId, LeaveType leaveType);

    void checkHistory(int userId);
}
