/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

/**
 *
 * @author Windows
 */
import Controller.FruitShopController;
import java.util.Scanner;
public class Menu extends AbstractMenu {

    private FruitShopController controller;

    public Menu(FruitShopController controller) {
        this.controller = controller;
    }

    @Override
    public void display() {
        controller.displayMainScreen();
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            display();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    controller.createFruitInput();
                    
                case 2:
                    controller.viewOrders();
                    break;
                case 3:
                    controller.shop();
                    break;
                case 4:
                    System.out.println("Exiting program. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
                    break;
            }
        }
    }
}
