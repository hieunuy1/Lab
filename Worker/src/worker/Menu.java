/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package worker;

import Manager.Management;
import Manager.Validation;
import java.util.Scanner;

/**
 *
 * @author gabri
 */
public class Menu {

    private static String[] ops = {
        "Add Worker",
        "Up salary",
        "Down salary",
        "Display all",
        "Display salary information",
        "Exit"
    };

    private static int getChoice() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < ops.length; i++) {
            System.out.println((i + 1) + ". " + ops[i]);
        }
        return Validation.getInt("Your choice: ", 1, ops.length);
    }

    public static void display() {
        Management m = new Management();
        int choice;

        do {
            System.out.println("========== WORKER MANAGEMENT========");
            choice = getChoice();
            switch (choice) {
                case 1:
                    m.addWorker();
                    break;
                case 2:
                    m.updateSalary(1);
                    break;
                case 3:
                    m.updateSalary(2);
                    break;
                case 4:
                    m.displayAll();
                    break;
                case 5:
                    m.getInformation();
                    break;
                case 6:
                    break;
            }

        } while (choice != 5);

    }
}
