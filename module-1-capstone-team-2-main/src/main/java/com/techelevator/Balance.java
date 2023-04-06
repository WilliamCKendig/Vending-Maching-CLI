package com.techelevator;

import java.math.BigDecimal;

public class Balance {
    private BigDecimal balance;

    public Balance() {
        this.balance = new BigDecimal("0");
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void updateBalance(BigDecimal amountAdded) {
        balance = balance.add(amountAdded);
    }
    public void subtractBalance(BigDecimal amountToSubtract){
        this.balance = balance.subtract(amountToSubtract);
    }
}
