package com.swarn.assignment.strategy;

/**
 * @author Swarn Singh.
 */
public class King {

    public void display() {
        System.out.println("I am a King");
    }

    public void fight(Weapon weapon) {
        System.out.println("I am fighting with " + weapon.getWeapon());
    }
}
