package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class BalanceTest {
    private Balance balance;

    @Before
    public void setup() {
        balance = new Balance();
    }

    @Test
    public void does_add_correctly() {
        BigDecimal testAmount = new BigDecimal(8);
        BigDecimal result = testAmount;

    }
}
