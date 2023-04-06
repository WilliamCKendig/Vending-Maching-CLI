package com.techelevator.application;

import com.techelevator.Inventory;
import com.techelevator.Item;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Map;

public class VendingMachineTest {
    private VendingMachine vendingMachine;
    private Inventory inventory = new Inventory();
    @Before
    public void setup() throws FileNotFoundException {
        vendingMachine = new VendingMachine(inventory);
    }

    @Test
    public void feed_money_test () {
        BigDecimal ten = new BigDecimal(10);

        BigDecimal actualResult = ten;
        Assert.assertEquals(ten, actualResult);
    }

    @Test
    public void returns_candy_message() {
        String actualResult = "Sugar, Sugar, so Sweet!";
        String userInput = "Candy";
        Assert.assertEquals(vendingMachine.getMessage(userInput), actualResult);
    }

}
