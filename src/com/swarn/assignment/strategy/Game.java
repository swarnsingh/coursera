package com.swarn.assignment.strategy;

/**
 * @author Swarn Singh.
 */
public class Game {

    public static void main(String[] args) {
        Weapon weapon = new Sword();
        King king = new King();
        king.display();
        king.fight(weapon);

        System.out.println();

        weapon = new Axe();
        Queen queen = new Queen();
        queen.display();
        queen.fight(weapon);
    }
}
