package com.home.shopping.exception;

/**
 * This Runtime exception represents the basket is empty.
 */
public class BasketEmptyException extends RuntimeException {

    public BasketEmptyException(String message) {
        super(message);
    }
}
