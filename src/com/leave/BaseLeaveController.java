package com.leave;

/**
 * @author Swarn Singh.
 */
public abstract class BaseLeaveController implements ILeave {

    public abstract void applyLeave(int userId, Leave leave);

    public abstract void editLeave(int userId, Leave leave);

    public abstract void withdrawLeave(int userId, Leave leave);

    @Override
    public void checkBalance(int userId, LeaveType leaveType) {
        System.out.println("My Leave Balance for LeaveType : " + leaveType.name());
    }

    @Override
    public void checkHistory(int userId) {
        System.out.println("User ID " + userId + " Leave History : ");
    }
}
