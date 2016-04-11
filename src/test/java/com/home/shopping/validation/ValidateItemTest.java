package com.home.shopping.validation;

import com.home.shopping.exception.InvalidItemInBasketException;
import com.home.shopping.exception.InvalidPriceException;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.fail;

/**
 * Test class for ValidateItem.
 */
public class ValidateItemTest {

    private ValidateItem validateItem;

    @Before
    public void setup() {
        validateItem = new ValidateItem();
    }

    @Test
    public void validateNameHappyPath() {
        List<String> availableItems = Arrays.asList("Bananas", "Oranges", "Apples", "Lemons", "Peaches");
        try {
            validateItem.validateName(availableItems, "Bananas");
        } catch (Exception e) {
            fail("Exception shouldn't be thrown");
        }
    }

    @Test(expected = InvalidItemInBasketException.class)
    public void validateNameForNonExistingItemName() {
        List<String> availableItems = Arrays.asList("Bananas", "Oranges", "Apples", "Lemons", "Peaches");
        validateItem.validateName(availableItems, "Pears");
    }

    @Test
    public void validatePriceHappyPath() {
        try {
            validateItem.validatePrice(10.0);
        } catch (Exception e) {
            fail("Exception shouldn't be thrown");
        }
    }

    @Test(expected = InvalidPriceException.class)
    public void validatePriceWhenItsZero() {
        validateItem.validatePrice(0);
    }


    @Test(expected = InvalidPriceException.class)
    public void validatePriceWhenItsNegative() {
        validateItem.validatePrice(-12.5);
    }
}
