package com.swarn.java;

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

        Hashids hashids = new Hashids("this is my salt");
        hashids.encodeHex("");
        System.out.println(hashids.decodeHex(""));
        String id = hashids.encode(1, 2, 3);
        long[] numbers = hashids.decode(id);

        System.out.println(animal.hashCode());

        //horse = (Horse) new Animal();
        //horse.eat();  // It will fail at runtime.
    }

    @Override
    public int hashCode() {
        String deviceId = "34d980f6050120bc";
        String partnerId = "5a9052b46b66d103ef3b2984";
        return deviceId.hashCode() * partnerId.hashCode();
    }
}
