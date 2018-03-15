package com.fruitshop.domain;

import com.fruitshop.exception.UnexpectedItemException;

public enum Item {

    APPLE(0.6),
    ORANGE(0.25);

    private double price;

    Item(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public static Item fromString(String itemStr) {
        try {
            return Item.valueOf(itemStr.toUpperCase());
        } catch (IllegalArgumentException ex) {
            throw new UnexpectedItemException(itemStr);
        }
    }
}
