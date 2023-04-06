package com.techelevator;

import java.math.BigDecimal;

public class Gum extends Item{

    public Gum(String slotIdentifier) {
        super(slotIdentifier);
    }

    @Override
    public String itemMessage() {
        return "Chewy, Chewy, Lots O Bubbles!";
    }
}

