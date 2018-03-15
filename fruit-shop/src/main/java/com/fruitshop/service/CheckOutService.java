package com.fruitshop.service;

import com.fruitshop.entity.Item;

import java.util.List;

public class CheckOutService {

    public double getTotalCost(List<String> items) {
        return items.stream().map(i -> Item.valueOf(i.toUpperCase()))
                .mapToDouble(Item::getPrice)
                .sum();
    }
}
