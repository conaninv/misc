package com.fruitshop.service;

import com.fruitshop.domain.Item;

import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class CheckOutService {

    public double getTotalCost(List<String> items) {
        return items.stream().map(Item::fromString)
                .mapToDouble(Item::getPrice)
                .sum();
    }

    public double getPromotionalTotalCost(List<String> items) {
        return items.stream().map(Item::fromString)
                .collect(groupingBy(Function.identity(), counting()))
                .entrySet()
                .stream().mapToDouble(e -> e.getKey().getOffer().apply(e.getValue(), e.getKey().getPrice()))
                .sum();
    }
}
