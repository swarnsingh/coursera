package com.swarn.assignment.strategy;

/**
 * @author Swarn Singh.
 */
public class Knight {

    public void display() {
        System.out.println("I am a Knight");
    }

    public void fight(Weapon weapon) {
        System.out.println("I am fighting with " + weapon.getWeapon());
    }
}
