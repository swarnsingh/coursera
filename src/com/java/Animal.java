package com.java;

/**
 * @author Swarn Singh.
 */
class Animal {
    public void eat() {
        System.out.println("Animal Eat");
    }
}

class Horse extends Animal {
    public void eat() {
        System.out.println("Horse Eat");
    }

    public void buck() {
        System.out.println("buck");
    }
}

class TestAnimal {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.eat();

        animal = new Horse();
        animal.eat();
        ((Horse) animal).buck();

        Horse horse = new Horse();
        horse.eat();

        //horse = (Horse) new Animal();
        //horse.eat();  // It will fail at runtime.
    }
}
