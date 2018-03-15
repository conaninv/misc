package com.fruitshop.domain;

import com.fruitshop.exception.UnexpectedItemException;

import java.util.function.BiFunction;

public enum Item {

    APPLE(0.6, Offer.BUY_ONE_GET_ONE_FREE),
    ORANGE(0.25, Offer.THREE_FOR_TWO);

    private double price;
    BiFunction<Long, Double, Double> offer;

    Item(double price, BiFunction offer) {
        this.price = price;
        this.offer = offer;
    }

    public Double getPrice() {
        return price;
    }

    public BiFunction<Long, Double, Double> getOffer() {
        return offer;
    }

    public static Item fromString(String itemStr) {
        try {
            return Item.valueOf(itemStr.toUpperCase());
        } catch (IllegalArgumentException ex) {
            throw new UnexpectedItemException(itemStr);
        }
    }
}
