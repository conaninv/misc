package com.fruitshop.service;

import com.fruitshop.domain.Item;

import java.util.List;

public class CheckOutService {

    public double getTotalCost(List<String> items) {
        return items.stream().map(Item::fromString)
                .mapToDouble(Item::getPrice)
                .sum();
    }
}
