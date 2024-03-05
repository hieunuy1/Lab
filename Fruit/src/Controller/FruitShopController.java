/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author Lul
 */
import Model.Fruit;
import Model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class FruitShopController {

    private ArrayList<Fruit> fruits;
    private Map<Customer, Hashtable<Integer, Integer>> orders;

    public FruitShopController() {
        fruits = new ArrayList<>();
        orders = new HashMap<>();
    }

   public void createFruit(String fruitId, String fruitName, String price, String quantity, String origin) {
    Validation.validateFruitId(fruitId);
    Validation.validatePrice(price);
    Validation.validateQuantity(quantity);
    Validation.validateName(fruitName);

    int id = Integer.parseInt(fruitId);
    double fruitPrice = Double.parseDouble(price);
    int fruitQuantity = Integer.parseInt(quantity);

    Fruit newFruit = new Fruit(id, fruitName, fruitPrice, fruitQuantity, origin);
    fruits.add(newFruit);
    System.out.println("Fruit created successfully!");

    Scanner scanner = new Scanner(System.in);
    System.out.print("Do you want to continue (Y/N)? ");
    String choice = scanner.next();
    if (choice.equalsIgnoreCase("Y")) {
        createFruitInput(); // Gọi lại phương thức để tiếp tục nhập
    } else {
        displayMainScreen();
    }
}

    public void createFruitInput() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter Fruit Id: ");
            String fruitIdStr = scanner.next();
            Validation.validateFruitId(fruitIdStr);

            System.out.print("Enter Fruit Name: ");
            String fruitName = scanner.next();

            System.out.print("Enter Price: ");
            String priceStr = scanner.next();
            Validation.validatePrice(priceStr);
            double price = Double.parseDouble(priceStr);

            System.out.print("Enter Quantity: ");
            String quantityStr = scanner.next();
            Validation.validateQuantity(quantityStr);
            int quantity = Integer.parseInt(quantityStr);

            System.out.print("Enter Origin: ");
            String origin = scanner.next();

            createFruit(fruitIdStr, fruitName, priceStr, quantityStr, origin);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input. " + e.getMessage());
            createFruitInput(); // Gọi lại phương thức để nhập lại
        }
    }

    public void viewOrders() {
        if (orders.isEmpty()) {
            System.out.println("No orders yet.");
            return;
        }

        System.out.println("Order Details:");
        for (Map.Entry<Customer, Hashtable<Integer, Integer>> entry : orders.entrySet()) {
            Customer customer = entry.getKey();
            Hashtable<Integer, Integer> order = entry.getValue();

            System.out.println("Customer: " + customer.getName());
            System.out.println("Product | Quantity | Price | Amount");

            double totalAmount = 0;

            for (Map.Entry<Integer, Integer> orderEntry : order.entrySet()) {
                int fruitId = orderEntry.getKey();
                int quantity = orderEntry.getValue();

                for (Fruit fruit : fruits) {
                    if (fruit.getFruitId() == fruitId) {
                        double amount = quantity * fruit.getPrice();
                        totalAmount += amount;

                        System.out.println(fruit.getFruitName() + "\t\t" + quantity + "\t\t" + fruit.getPrice()
                                + "$\t" + amount + "$");
                    }
                }
            }

            System.out.println("Total: " + totalAmount + "$");
            System.out.println();
        }
    }

    public void displayMainScreen() {
        System.out.println("\nFRUIT SHOP SYSTEM");
        System.out.println("1. Create Fruit");
        System.out.println("2. View Orders");
        System.out.println("3. Shopping (for buyer)");
        System.out.println("4. Exit");
        System.out.print("Please choose an option (1-4): ");
    }

    public void displayFruitList() {
        System.out.println("\nList of Fruit:");
        System.out.println("| ++ Item ++ | ++ Fruit Name ++ | ++ Origin ++ | ++ Price ++ |");
        for (int i = 0; i < fruits.size(); i++) {
            Fruit fruit = fruits.get(i);
            System.out.println("\t" + (i + 1) + "\t\t" + fruit.getFruitName() + "\t\t"
                    + fruit.getOrigin() + "\t\t" + fruit.getPrice() + "$");
        }
    }

    public void shop() {
    Scanner scanner = new Scanner(System.in);
    displayFruitList();

    System.out.println("To order, select Item by entering the Item number, Fruit Name, or Fruit Id:");
    String userInput = scanner.next();

    Fruit selectedFruit = null;

    try {
        int selectedItem = Integer.parseInt(userInput);
        if (selectedItem >= 1 && selectedItem <= fruits.size()) {
            selectedFruit = fruits.get(selectedItem - 1);
        }
    } catch (NumberFormatException ignored) {
        for (Fruit fruit : fruits) {
            if (fruit.getFruitName().equalsIgnoreCase(userInput)) {
                selectedFruit = fruit;
                break;
            }
        }
    }

    if (selectedFruit == null) {
        System.out.println("Invalid selection. Please select a valid Item, Fruit Name, or Fruit Id.");
        shop();
        return;
    }

    System.out.println("You selected: " + selectedFruit.getFruitName());
    System.out.print("Please input quantity: ");
    int quantity = scanner.nextInt();

    System.out.print("Do you want to order now (Y/N)? ");
    String orderChoice = scanner.next();

    if (orderChoice.equalsIgnoreCase("Y")) {
        double amount = quantity * selectedFruit.getPrice();
        System.out.println("Product | Quantity | Price | Amount");
        System.out.println(selectedFruit.getFruitName() + "\t\t" + quantity + "\t\t"
                + selectedFruit.getPrice() + "$\t" + amount + "$");

        System.out.print("Input your name: ");
        String customerName = scanner.next();

        Customer customer = new Customer(customerName);
        if (orders.containsKey(customer)) {
            Hashtable<Integer, Integer> existingOrder = orders.get(customer);
            if (existingOrder.containsKey(selectedFruit.getFruitId())) {
                existingOrder.put(selectedFruit.getFruitId(),
                        existingOrder.get(selectedFruit.getFruitId()) + quantity);
            } else {
                existingOrder.put(selectedFruit.getFruitId(), quantity);
            }
        } else {
            Hashtable<Integer, Integer> order = new Hashtable<>();
            order.put(selectedFruit.getFruitId(), quantity);
            orders.put(customer, order);
        }

        System.out.println("Total: " + amount + "$");
        System.out.println("Order placed successfully for " + customerName);
        displayMainScreen();
    } else {
        shop();
    }
}
}
