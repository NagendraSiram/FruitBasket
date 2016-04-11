package com.home.shopping.validation;

import com.home.shopping.exception.InvalidItemInBasketException;
import com.home.shopping.exception.InvalidPriceException;

import java.util.List;

/**
 * This class validates the Item properties like item name & price.
 */
public class ValidateItem {

    /*
        This method validates the Item name and
        throws InvalidItemInBasketException if the item does not exists.
     */
    public void validateName(List availableItems, String itemName) {
        boolean noMatch = availableItems.stream()
                .noneMatch(s -> s.equals(itemName));

        if (noMatch) {
            throw new InvalidItemInBasketException("Item is not available in stock or not recognised");
        }
    }

    /*
        This method validates the Item price and
        throws InvalidPriceException if the price is not valid.
     */
    public void validatePrice(double price) {
        if (price <= 0) {
            throw new InvalidPriceException("Item price is invalid");
        }
    }
}
