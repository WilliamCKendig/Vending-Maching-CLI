package com.techelevator;

import java.math.BigDecimal;

public abstract class Item {
    private BigDecimal price;
    private String name;
    private String type;
    private String slotIdentifier;

    public Item(String slotIdentifier) {
        this.slotIdentifier = slotIdentifier;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSlotIdentifier() {
        return slotIdentifier;
    }

    public void setSlotIdentifier(String slotIdentifier) {
        this.slotIdentifier = slotIdentifier;
    }


    public abstract String itemMessage ();


}

