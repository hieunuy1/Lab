/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Manager;

import java.util.List;
import java.util.Scanner;
import object.Worker;

/**
 *
 * @author gabri
 */
public class Validation {

    public static Scanner sc = new Scanner(System.in);

    public static int getInt(String msg, int min, int max) {
        int n;
        while (true) {
            try {
                System.out.println(msg);
                n = Integer.parseInt(sc.nextLine());
                if (min <= n && n <= max) {
                    break;
                }
                throw new NumberFormatException();
            } catch (NumberFormatException ex) {
                System.out.println("Please enter an integer number in rage" + min + " to " + max);
            }
        }
        return n;
    }

    public static double getDouble(String msg, double min, double max) {
        double n;
        while (true) {
            try {
                System.out.println(msg);
                n = Double.parseDouble(sc.nextLine());
                if (min <= n && n <= max) {
                    break;
                }

            } catch (NumberFormatException ex) {
                System.out.println("Please enter an real number in rage" + min + " to " + max);
            }
        }
        return n;
    }

    public static String getCode(String msg, String err, List<Worker> wList, int mode) {
        String s;
        while (true) {
            System.out.print(msg);
            s = sc.nextLine();
            if (!s.isEmpty()) {
                if ((mode == 1 && getWorker(s, wList) == null) || (mode == 2 && getWorker(s, wList)!= null) ) {
                    break;
                }
            }
            System.out.println(err);
        }

        return s;
    }

    public static Worker getWorker(String id, List<Worker> wList) {
        for (Worker o : wList) {
            if (o.getid().equals(id)) {
                return o;
            }

        }
        return null;
    }
}
