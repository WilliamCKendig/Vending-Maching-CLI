package com.techelevator;

public class Candy extends Item{

    public Candy(String slotIdentifier) {
        super(slotIdentifier);
    }


    @Override
    public String itemMessage() {
        return "Sugar, Sugar, so Sweet!";
    }
}
