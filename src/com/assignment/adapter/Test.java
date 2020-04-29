package com.assignment.adapter;

/**
 * @author Swarn Singh.
 */
public class Test {
    public static void main(String[] args) {
        ShopInventory shopInventory = new ShopInventory();
        Y y = new Y();
        Product product = new ProductAdapter();
        shopInventory.consume(product);
    }
}
