package com.home.shopping.exception;

/**
 * This Runtime exception represents the item price in the basket is not valid.
 */
public class InvalidPriceException extends RuntimeException {

    public InvalidPriceException(String message) {
        super(message);
    }
}
