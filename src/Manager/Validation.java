/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Manager;

import java.util.Scanner;

/**
 *
 * @author Windows
 */
public class Validation {
     private static Scanner sc = new Scanner(System.in);
      public static String getString(String msg) {
        while (true) {
            System.out.println(msg);
            String s = sc.nextLine();
            if (!s.isEmpty()) {
                return s;
            }
            System.out.println("Empty path is not allowed!!!");
        }
    }
}
