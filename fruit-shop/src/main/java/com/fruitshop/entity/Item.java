package com.fruitshop.entity;

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
}
