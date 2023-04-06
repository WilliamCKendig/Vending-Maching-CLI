package com.techelevator;

public class Drink extends Item{


    public Drink(String slotIdentifier) {
        super(slotIdentifier);
    }

    @Override
    public String itemMessage() {
        return "Drinky, Drinky, Slurp Slurp!";
    }
}
