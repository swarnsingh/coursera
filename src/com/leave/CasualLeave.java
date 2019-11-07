package com.leave;

/**
 * @author Swarn Singh.
 */
public class CasualLeave extends BaseLeaveController {

    @Override
    public void applyLeave(int userId, Leave leave) {
        System.out.println("Applied leave for userId " + userId + " : " + leave.toString());
    }

    @Override
    public void editLeave(int userId, Leave leave) {
        System.out.println("EditLeave leave for userId " + userId + " : " + leave.toString());
    }

    @Override
    public void withdrawLeave(int userId, Leave leave) {
        System.out.println("WithdrawLeave leave for userId " + userId + " : " + leave.toString());
    }
}
