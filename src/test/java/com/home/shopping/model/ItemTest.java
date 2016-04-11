package com.home.shopping.model;

import com.home.shopping.model.Item;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * JUnit test for Item class.
 */
public class ItemTest {

    @Test
    public void testItemConstructor(){
        final String name = "Bananas";
        final double price = 0.64;
        Item item = new Item(name, price);

        assertEquals("Item name didn't match", name, item.getName());
        assertEquals("Price didn't match", price, item.getPrice());
    }
}
