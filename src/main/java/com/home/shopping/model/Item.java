package com.home.shopping.model;

/**
 * Item class holds name of the basket item and associated price.
 */
public class Item {

    private final String name;

    private final double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /*
        Returns the name of the item
     */
    public String getName() {
        return name;
    }

     /*
        Returns the price of the item
     */
    public double getPrice() {
        return price;
    }
}
