package com.techelevator;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class Stock extends Inventory{
    public int startingStock = 6;
   public Map<String, Integer> stock = new HashMap<>();

    public Stock() throws FileNotFoundException {}
    public void stockFiller() throws FileNotFoundException {
        for (String slotIdentifier : getInventory().keySet()) {
            this.stock.put(slotIdentifier, startingStock);

        }
    }


    public void updateStock(String userInput){
        for (String slotIdentifier : getStock().keySet()) {
            if (userInput.equals(slotIdentifier)) {
                int number = getStock().get(slotIdentifier);
                this.stock.replace(slotIdentifier, number - 1);
            }
        }
    }


    public Map<String, Integer> getStock(){
        return this.stock;
    }



}
