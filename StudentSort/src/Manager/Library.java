/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Manager;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Windows
 */
public class Library {
    protected Scanner sc;

    public Library() {
        sc = new Scanner(System.in);
    }

    public String getString(String mess) {
        System.out.print(mess + ": ");
        return sc.nextLine();
    }

    public int getInt(String promt, int m, int n) {
        int s = -1;
        while (true) {
            System.out.print(promt + ": ");
            try {
                s = Integer.parseInt(sc.nextLine());
                if (s >= m && s <= n) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Please enter a number between " + m + " and " + n);
            }
        }
        return s;
    }
    
    public double getDouble(String promt, double m, double n) {
        double s = -1;
        while (true) {
            System.out.print(promt + ": ");
            try {
                s = sc.nextDouble();
                sc.nextLine();
                if (s >= m && s <= n) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Please enter a number between " + m + " and " + n);
            }
        }
        return s;
    }
    
    public char getChar(String mess) {
        char ch = ' ';
        try {
            System.out.println(mess + ": ");
            ch = (char) System.in.read();
        } catch (IOException i) {
            System.out.println("Error");
        }
        return ch;
    }
}
