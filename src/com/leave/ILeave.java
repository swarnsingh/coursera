package com.leave;

/**
 * @author Swarn Singh.
 */
public interface ILeave {
    public void applyLeave(int userId, Leave leave);

    public void editLeave(int userId, Leave leave);

    public void withdrawLeave(int userId, Leave leave);

    public void checkBalance(int userId, LeaveType leaveType);

    public void checkHistory(int userId);
}
