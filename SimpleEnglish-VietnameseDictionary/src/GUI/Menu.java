/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import Manager.Dictionary;
import Manager.Validation;
import java.io.IOException;

/**
 *
 * @author Windows
 */
public class Menu {

    private static String[] ops = {
        "Add word",
        "Delete word",
        "Translate word",
        "Exit"
    };

    public static void display() throws IOException {
        Dictionary d = new Dictionary();

        int choice = 0;
        do {
            System.out.println("==========Dictionary Program=============");
            for (int i = 0; i < ops.length; i++) {
                System.out.println((i + 1) + ". " + ops[i]);
            }
            choice = Validation.getInt("Choose: ", 1, ops.length);
            switch (choice) {
                case 1:
                    System.out.println("--------------Add-----------");
                    d.addWord();
                    break;
                case 2:
                    System.out.println("--------------Delete-----------");

                    d.removeWord();
                    break;
                case 3:
                    System.out.println("--------------Translate-----------");

                    d.translate();
                    break;
                case 4:
                    break;

            }
        } while (choice != ops.length);
    }
}
