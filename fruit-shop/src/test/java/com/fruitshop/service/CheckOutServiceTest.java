package com.fruitshop.service;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CheckOutServiceTest {

    private CheckOutService checkOutService;

    @Before
    public void setUp() {
        checkOutService = new CheckOutService();
    }

    @Test
    public void testGetTotalCost() {
        List<String> shoppingCart = Arrays.asList("Apple", "Apple", "Orange", "Apple");
        double totalCost = checkOutService.getTotalCost(shoppingCart);

        assertThat(totalCost, is(2.05));
    }

}
