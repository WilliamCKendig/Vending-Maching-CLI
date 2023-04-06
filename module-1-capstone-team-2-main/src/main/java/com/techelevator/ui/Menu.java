package com.techelevator.ui;

import com.techelevator.Inventory;
import com.techelevator.Item;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    private Map<String, Item> displayInventory = new HashMap<>();

    public Menu(Inventory inventory) throws FileNotFoundException {
        displayInventory = inventory.getInventory();
    }

    public Menu() {
    }

    public void displayHomeScreen(){
        System.out.println();
        System.out.println("***************************************************");
        System.out.println("                      Home");
        System.out.println("***************************************************");
        System.out.println();

        System.out.println("What would you like to do?");
        System.out.println();

        System.out.println("D) Display Items");
        System.out.println("P) Purchase");
        System.out.println("E) Exit");

        System.out.println();
        System.out.print("Please select an option: ");
        System.out.println();

    }


    public String getHomeScreenOption() {


        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toLowerCase();
        if (option.equals("d")) {
            return "Items List";
        } else if (option.equals("p")) {
            return "Purchase Menu";
        } else if (option.equals("e")){
            return "Exit";
        } else return "Invalid Input";
    }

    public void displayMessage(String message) {
        System.out.println();
        System.out.println(message);
        System.out.println();
    }

    public String getPurchaseOption() {
        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toLowerCase();
        if (option.equals("m")) {
            return "Feed Money";
        } else if (option.equals("s")) {
            return "Select Item";
        } else if (option.equals("f")) {
            return "Finish Transaction";
        } else {
            return "";
        }
    }



    public void displayPurchaseMenu() {
        displayMessage(">(M) Feed Money");
        displayMessage(">(S) Select Item");
        displayMessage(">(F) Finish Transaction");
    }

    public String feedMoneyMenuSelection(){
        String selectedOption = scanner.nextLine();
        return selectedOption.trim().toLowerCase();
    }

    public void feedingMoneyMenu() {
        displayMessage("Insert your cash");
        displayMessage("$1, $5, $10, or $20");
    }
    public void doneFeedingMenu() {
        displayMessage("Insert your cash");
        displayMessage("$1, $5, $10, or $20");
        displayMessage("Or");
        displayMessage("Done feeding money? Yes or No");
    }

    public String selectItemMenuOption (){
        String selectedOption = scanner.nextLine();
        return selectedOption.trim().toUpperCase();
    }


}


