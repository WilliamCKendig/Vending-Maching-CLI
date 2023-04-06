package com.techelevator;

public class Munchy extends Item{

    public Munchy(String slotIdentifier) {
        super(slotIdentifier);
    }

    @Override
    public String itemMessage() {
        return "Munchy, Munchy, so Good!";
    }
}
