package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;

public class Inventory {


    public Inventory() {

    }


    public Map<String, Item> getInventory() throws FileNotFoundException {

        File inventoryFile = new File("catering.csv");  //"catering1.csv"
        Map<String, Item> inventory = new HashMap<>();
        try(Scanner scanner = new Scanner(inventoryFile)) {

            while (scanner.hasNextLine()) {
                String lineFromInventory = scanner.nextLine();
                String[] itemInfo = lineFromInventory.split(",");
                Item items;
                if(itemInfo[3].equals("Gum")){
                    items = new Gum(itemInfo[0]);
                } else if(itemInfo[3].equals("Drink")) {
                    items = new Drink(itemInfo[0]);
                } else if(itemInfo[3].equals("Candy")){
                    items = new Candy(itemInfo[0]);
                } else {
                    items = new Munchy(itemInfo[0]);
                }
                items.setName(itemInfo[1]);
                BigDecimal price = new BigDecimal(itemInfo[2]);
                items.setPrice(price);
                items.setType(itemInfo[3]);

                inventory.put(itemInfo[0], items);
            }
        }
        return inventory;
    }

}


