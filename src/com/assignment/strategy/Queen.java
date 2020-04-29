package com.assignment.strategy;

/**
 * @author Swarn Singh.
 */
public class Queen {

    public void display() {
        System.out.println("I am a Queen");
    }

    public void fight(Weapon weapon) {
        System.out.println("I am fighting with " + weapon.getWeapon());
    }
}
