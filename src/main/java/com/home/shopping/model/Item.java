package com.home.shopping.model;

/**
 * Item class holds name of the basket item and associated price.
 */
public class Item {

    private String name;

    private double price;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (Double.compare(item.price, price) != 0) return false;
        return name.equals(item.name);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name.hashCode();
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
