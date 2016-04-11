package com.home.shopping;

import com.home.shopping.exception.BasketEmptyException;
import com.home.shopping.model.Item;
import com.home.shopping.validation.ValidateItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This FruitBasket class holds the items in the basket and also has method to calculate the total items in the basket.
 */
public class FruitBasket {

    /*
     Holds the items that are currently available in stock.
    */
    private List<String> availableItems = Arrays.asList("Bananas", "Oranges", "Apples", "Lemons", "Peaches");

    /*
        Holds the basket items
     */
    private final List<Item> basketItems = new ArrayList<>();


    private ValidateItem validateItem = new ValidateItem();

    /*
        This method adds the item to basket
     */
    public void addItem(Item item) {
        validateItem.validateName(availableItems, item.getName());
        validateItem.validatePrice(item.getPrice());
        basketItems.add(item);
    }

    /*
      This method calculates the total cost of the items in the basket.
      Basket should contain one or more items to return the total cost.
      throws BasketEmptyException when Basket is empty
     */
    public Double calculateCost() throws BasketEmptyException {
        if (basketItems.isEmpty()) {
            throw new BasketEmptyException("Basket is empty to calculate cost");
        }
        return basketItems.stream()
                .mapToDouble(Item::getPrice)
                .reduce(0, (a, b) -> a + b);
    }

    /*
        returns the basket Items
     */
    public List<Item> getBasketItems() {
        return basketItems;
    }
}
