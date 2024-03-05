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

    public static int getInt(String msg, int min, int max) {
        int n;
        if (min > max) {
            int temp = min;
            min = max;
            max = temp;
        }
        while (true) {
            try {
                System.out.println(msg);
                n = Integer.parseInt(sc.nextLine());
                if (min <= n && n <= max) {
                    return n;
                }
            } catch (NumberFormatException ex) {
                System.out.println("Wrong Format. Please enter a number in range: " + min + " to " + max);
            }
        }

    }

    public static String getString(String msg) {
        while (true) {
            System.out.println(msg);
            String s = sc.nextLine();
            if (!s.isEmpty()) {
                return s;
            }
            System.out.println("Emtry word is now allowed!!!");
        }
    }

    public static boolean getYN(String msg) {
        while (true) {
            System.out.println(msg);
            String s = sc.nextLine();
            if (s.equalsIgnoreCase("n")) {
                return false;
            }
            System.out.println("Please input only Y/N!!!");
        }
    }

}
