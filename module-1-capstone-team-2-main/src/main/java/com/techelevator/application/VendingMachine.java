package com.techelevator.application;

import com.techelevator.*;
import com.techelevator.ui.Menu;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;

import static com.techelevator.Money.*;


public class VendingMachine {
    Audit audit = new Audit();
    Menu userInterface = new Menu();
    Stock currentStock = new Stock();
    Balance currentBalance = new Balance();
    private Map<String, Item> displayInventory = new HashMap<>();

    public VendingMachine(Inventory inventory) throws FileNotFoundException {
        displayInventory = inventory.getInventory();
        currentStock.stockFiller();
    }

    public void run() throws FileNotFoundException {
        audit.auditWriter("Starting Vending Machine");
        while (true) {
            userInterface.displayHomeScreen();
            String choice = userInterface.getHomeScreenOption();

            if (choice.equals("Items List")) {
                for (Map.Entry<String, Item> currentEntry : displayInventory.entrySet()) {
                    String itemProperties = currentEntry.getKey() + " " + currentEntry.getValue().getName()
                            + " " + currentEntry.getValue().getPrice()
                            + " " + currentStock.getStock().get(currentEntry.getKey());
                    userInterface.displayMessage(itemProperties);
                }
            }

           else if (choice.equals("Purchase Menu")) {
                userInterface.displayPurchaseMenu();
                 String purchaseChoice = userInterface.getPurchaseOption();
                if (purchaseChoice.equals("Select Item")) {
                    selectItem();
                }
                if (purchaseChoice.equals("Feed Money")) {
                    feedMoney();
                }
                if (purchaseChoice.equals("Finish Transaction")) {
                    dispenseChange();
                }
            }

           else if (choice.equals("Exit")) {
                userInterface.displayMessage("Good Bye");
                audit.auditWriter("Vending Machine Turning Off");
                break;
            } else userInterface.displayMessage("Invalid input, try again.");
        }
    }

    public void selectItem() throws FileNotFoundException {

        userInterface.displayMessage("Make your selection. Choose the slot identifier desired.");

        for (Map.Entry<String, Item> currentEntry : displayInventory.entrySet()) {
            String itemProperties = currentEntry.getKey() + " " + currentEntry.getValue().getName()
                    + " " + currentEntry.getValue().getPrice();

            userInterface.displayMessage(itemProperties);
        }

           String userInput = userInterface.selectItemMenuOption();

        if (!displayInventory.containsKey(userInput)) {
            userInterface.displayMessage("Invalid Slot Identifier. Try Again");
        } else if (currentStock.getStock().get(userInput).equals(0)) {
            userInterface.displayMessage("Item Is Out Of Stock, Try Another Item");
        }

            else if (currentBalance.getBalance().compareTo(displayInventory.get(userInput).getPrice()) < 0){
                userInterface.displayMessage("Not enough money for this item.");
            }

            else if (displayInventory.containsKey(userInput)) {

                currentStock.updateStock(userInput);
                currentBalance.subtractBalance(displayInventory.get(userInput).getPrice());
                userInterface.displayMessage("Dispensing " + displayInventory.get(userInput).getName()
                + " " + displayInventory.get(userInput).getPrice() + " " + currentBalance.getBalance() + " " +
                        getMessage(userInput));
                audit.auditWriter(displayInventory.get(userInput).getName() + " \t " +
                        displayInventory.get(userInput).getPrice() + " " + currentBalance.getBalance() );
            }

    }

    public String getMessage (String userInput){
        Candy candy = new Candy(userInput);
        Drink drink = new Drink(userInput);
        Gum gum = new Gum(userInput);
        Munchy munchy = new Munchy(userInput);
        String type = displayInventory.get(userInput).getType();
        if (type.equals("Candy")){
            return candy.itemMessage();
        } if (type.equals("Drink")){
            return drink.itemMessage();
        } if (type.equals("Gum")){
            return gum.itemMessage();
        } if (type.equals("Munchy")){
            return munchy.itemMessage();
        }
        return "";
    }


    public void feedMoney() throws FileNotFoundException {
        String userInput = "";
        userInterface.feedingMoneyMenu();
        while (!userInput.equals("Yes")) {
            userInput = userInterface.feedMoneyMenuSelection();


            if (userInput.equals("$1") || userInput.equals("1")) {
                currentBalance.updateBalance(ONE_DOLLAR);
                userInterface.displayMessage("Your balance is " + currentBalance.getBalance());
                userInterface.doneFeedingMenu();
                audit.auditWriter("MONEY FED: " + ONE_DOLLAR + " " + currentBalance.getBalance());
            } else if (userInput.equals("$5") || userInput.equals("5")) {
                currentBalance.updateBalance(Money.FIVE_DOLLARS);
                userInterface.displayMessage("Your balance is " + currentBalance.getBalance());
                userInterface.doneFeedingMenu();
                audit.auditWriter("MONEY FED: " + FIVE_DOLLARS + " " + currentBalance.getBalance());
            } else if (userInput.equals("$10") || userInput.equals("10")) {
                currentBalance.updateBalance(Money.TEN_DOLLARS);
                userInterface.displayMessage("Your balance is " + currentBalance.getBalance());
                userInterface.doneFeedingMenu();
                audit.auditWriter("MONEY FED: " + TEN_DOLLARS + " " + currentBalance.getBalance());
            } else if (userInput.equals("$20") || userInput.equals("20")) {
                currentBalance.updateBalance(Money.TWENTY_DOLLARS);
                userInterface.displayMessage("Your balance is " + currentBalance.getBalance());
                userInterface.doneFeedingMenu();
                audit.auditWriter("MONEY FED:      " + TWENTY_DOLLARS + " " + currentBalance.getBalance());
            }
            else if (userInput.equalsIgnoreCase("yes")) {
                break;
            } else userInterface.displayMessage("Invalid money amount.");


        }
    }
    public void dispenseChange () throws FileNotFoundException {
        BigDecimal zero = new BigDecimal(0);

        while (currentBalance.getBalance().compareTo(zero) > 0) {
            audit.auditWriter("CHANGE GIVEN: \t " + currentBalance.getBalance() + " " + "0.00");
            while (currentBalance.getBalance().compareTo(ONE_DOLLAR) >= 0) {
                currentBalance.subtractBalance(ONE_DOLLAR);
                userInterface.displayMessage("Dispensing One Dollar");
            }
            while (currentBalance.getBalance().compareTo(QUARTER) >= 0) {
                currentBalance.subtractBalance(QUARTER);
                userInterface.displayMessage("Dispensing One Quarter");
            }
            while (currentBalance.getBalance().compareTo(DIME) >= 0) {
                currentBalance.subtractBalance(DIME);
                userInterface.displayMessage("Dispensing One Dime");
            }
            while (currentBalance.getBalance().compareTo(NICKEL) >= 0) {
                currentBalance.subtractBalance(NICKEL);
                userInterface.displayMessage("Dispensing One Nickel");
            }

        }

    }
}

