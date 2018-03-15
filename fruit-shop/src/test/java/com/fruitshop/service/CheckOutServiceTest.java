package com.fruitshop.service;

import com.fruitshop.exception.UnexpectedItemException;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

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
        int numberOfApples = 3;
        int numberOfOranges = 1;
        List<String> shoppingCart = populateShoppingCart(numberOfApples, numberOfOranges);
        double totalCost = checkOutService.getTotalCost(shoppingCart);

        assertThat(totalCost, is(2.05));
    }

    @Test(expected = UnexpectedItemException.class)
    public void testGetTotalCostWithUnexpectedItem() {
        int numberOfApples = 3;
        int numberOfOranges = 1;
        List<String> unexpectedItems = Collections.singletonList("Banana");
        List<String> shoppingCart = populateShoppingCart(numberOfApples, numberOfOranges, unexpectedItems);
        checkOutService.getTotalCost(shoppingCart);
    }

    @Test
    public void testGetPromotionalTotalCostWithExactMatch() {
        int numberOfApples = 2;
        int numberOfOranges = 3;
        List<String> shoppingCart = populateShoppingCart(numberOfApples, numberOfOranges);
        double totalCost = checkOutService.getPromotionalTotalCost(shoppingCart);
        // 2x Apples = £0.6, 3x Oranges = £0.5
        assertThat(totalCost, is(1.1));
    }

    @Test
    public void testGetPromotionalTotalCostWithMoreThanExactMatch() {
        int numberOfApples = 3;
        int numberOfOranges = 4;
        List<String> shoppingCart = populateShoppingCart(numberOfApples, numberOfOranges);
        double totalCost = checkOutService.getPromotionalTotalCost(shoppingCart);
        // 3x Apples = £1.2, 4x Oranges = £0.75
        assertThat(totalCost, is(1.95));
    }

    @Test
    public void testGetPromotionalTotalCostWithLessThanExactMatch() {
        int numberOfApples = 1;
        int numberOfOranges = 2;
        List<String> shoppingCart = populateShoppingCart(numberOfApples, numberOfOranges);
        double totalCost = checkOutService.getPromotionalTotalCost(shoppingCart);
        // 1x Apples = £0.6, 2x Oranges = £0.5
        assertThat(totalCost, is(1.1));
    }

    @Test(expected = UnexpectedItemException.class)
    public void testGetPromotionalTotalCostWithUnexpectedItem() {
        int numberOfApples = 2;
        int numberOfOranges = 3;
        List<String> unexpectedItems = Collections.singletonList("Banana");
        List<String> shoppingCart = populateShoppingCart(numberOfApples, numberOfOranges, unexpectedItems);
        checkOutService.getPromotionalTotalCost(shoppingCart);
    }

    private List<String> populateShoppingCart(int numberOfApples, int numberOfOranges) {
        List<String> shoppingCart = new ArrayList<>();
        IntStream.rangeClosed(1, numberOfApples).forEach(n -> shoppingCart.add("Apple"));
        IntStream.rangeClosed(1, numberOfOranges).forEach(n -> shoppingCart.add("Orange"));

        Collections.shuffle(shoppingCart);
        return shoppingCart;
    }

    private List<String> populateShoppingCart(int numberOfApples, int numberOfOranges, List<String> unexpectedItems) {
        List<String> shoppingCart = populateShoppingCart(numberOfApples, numberOfOranges);
        shoppingCart.addAll(unexpectedItems);

        Collections.shuffle(shoppingCart);
        return shoppingCart;
    }
}
