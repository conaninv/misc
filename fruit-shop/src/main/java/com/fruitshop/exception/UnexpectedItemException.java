package com.fruitshop.exception;

public class UnexpectedItemException extends RuntimeException {
    private static String MESSAGE = "Unexpected item detected: %s";

    public UnexpectedItemException(String item) {
        super(String.format(MESSAGE, item));
    }
}
