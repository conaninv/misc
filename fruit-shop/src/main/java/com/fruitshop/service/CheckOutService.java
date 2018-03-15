package com.fruitshop.service;

import com.fruitshop.entity.Item;
import com.fruitshop.exception.UnexpectedItemException;

import java.util.List;

public class CheckOutService {

    public double getTotalCost(List<String> items) {
        return items.stream().map(Item::fromString)
                .mapToDouble(Item::getPrice)
                .sum();
    }
}
