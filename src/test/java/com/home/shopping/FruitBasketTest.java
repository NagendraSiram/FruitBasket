package com.home.shopping;

import com.home.shopping.exception.BasketEmptyException;
import com.home.shopping.exception.InvalidItemInBasketException;
import com.home.shopping.exception.InvalidPriceException;
import com.home.shopping.model.Item;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Test class for FruitBasket class.
 */
public class FruitBasketTest {

    private FruitBasket fruitBasket;

    @Before
    public void setUp() {
        fruitBasket = new FruitBasket();
    }

    @Test
    public void testAddItemToBasketHappyPath() {
        fruitBasket.addItem(new Item("Bananas", 0.64));

        int expectedBasketSize = 1;
        assertEquals("Number of items in the basket didnt match", expectedBasketSize, fruitBasket.getBasketItems().size());
    }

    @Test(expected = InvalidItemInBasketException.class)
    public void addItemWithInvalidItemName() {
        fruitBasket.addItem(new Item("Pears", 1.50));
    }

    @Test(expected = InvalidPriceException.class)
    public void addItemWithInvalidItemPrice() {
        fruitBasket.addItem(new Item("Apples", -1.50));
    }

    @Test(expected = BasketEmptyException.class)
    public void calculateCostWhenBasketIsEmpty() {
        fruitBasket.calculateCost();
    }

    @Test
    public void calculateCostHappyPath() {
        fruitBasket.addItem(new Item("Bananas", 1.50));
        fruitBasket.addItem(new Item("Apples", 2.75));

        double expectedTotalCost = 4.25;
        assertEquals("Total cost didn't match", expectedTotalCost, fruitBasket.calculateCost());
    }

    @Test
    public void calculateCostInCaseOfDuplicateItemsInBasket(){
        fruitBasket.addItem(new Item("Bananas", 1.50));
        fruitBasket.addItem(new Item("Bananas", 1.50));

        double expectedTotalCost = 3.00;
        assertEquals("Total cost didn't match", expectedTotalCost, fruitBasket.calculateCost());
    }

}
