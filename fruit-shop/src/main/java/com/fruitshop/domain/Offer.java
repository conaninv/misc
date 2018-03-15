package com.fruitshop.domain;

import java.util.function.BiFunction;

public class Offer {

    public static BiFunction<Long, Double, Double> BUY_ONE_GET_ONE_FREE = (amount, unitPrice) ->
        (amount / 2) * unitPrice + (amount % 2) * unitPrice;

    public static BiFunction<Long, Double, Double> THREE_FOR_TWO = (amount, unitPrice) ->
            (amount / 3) * (unitPrice * 2) + (amount % 3) * unitPrice;

}
