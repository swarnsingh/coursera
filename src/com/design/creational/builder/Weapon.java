package com.design.creational.builder;

/**
 * Weapon enumeration.
 */
public enum Weapon {

    DAGGER, SWORD, AXE, WAR_HAMMER, BOW;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
