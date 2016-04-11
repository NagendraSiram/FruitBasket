package com.home.shopping.exception;

/**
 * This Runtime exception represents the item in the basket is not valid.
 */
public class InvalidItemInBasketException extends RuntimeException {

    public InvalidItemInBasketException(String message) {
        super(message);
    }
}
