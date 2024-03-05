/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Info;

import java.util.Scanner;

/**
 *
 * @author tung
 */
 public class StudentManager {

    private static final Scanner in = new Scanner(System.in);

    private String checkInputString() {

        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty.");
            } else {
                return result;
            }
        }
    }

    private int checkInputInt() {
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine());
                if (result <= 0) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException ex) {
                System.err.println("Input must be digit.");
            }
        }
    }

    private double checkInputSalary() {
        while (true) {
            try {
                double result = Double.parseDouble(in.nextLine());
                if (result < 0) {
                    System.err.println("Salary must be greater than zero");
                } else {
                    return result;
                }
            } catch (NumberFormatException ex) {
                System.err.println("You must input digit.");
                System.out.print("Please input salary: ");
            }
        }
    }

    private int checkInputNumberStudent() {
        System.out.print("Enter number student: ");
        int n = checkInputInt();
        return n;
    }

    private Persons inputPersonInfo() {
        System.out.println("Input Information of Person");
        System.out.print("Please input name: ");
        String name = checkInputString();
        System.out.print("Please input address: ");
        String address = checkInputString();
        System.out.print("Please input salary: ");
        double salary = checkInputSalary();
        return new Persons(name, address, salary);
    }

    private void swap(PersonWrapper person1, PersonWrapper person2) {
        Persons temp = person1.p;
        person1.p = person2.p;
        person2.p = temp;
    }

    private void sortBySalary(Persons[] persons, PersonWrapper[] listPersonWrapper) {
        int n = persons.length;

        for (int i = 0; i < persons.length; i++) {
            listPersonWrapper[i] = new PersonWrapper(persons[i]);
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (listPersonWrapper[i].p.salary > listPersonWrapper[j].p.salary) {
                    swap(listPersonWrapper[i], listPersonWrapper[j]);
                }
            }
        }
        System.err.println("Sort success.");
        return;
    }

    public void start() {
        int n = checkInputNumberStudent();
        Persons[] persons = new Persons[n];
        for (int i = 0; i < persons.length; i++) {
            persons[i] = inputPersonInfo();
        }
        PersonWrapper[] listPersonWrapper = new PersonWrapper[persons.length];
        sortBySalary(persons, listPersonWrapper);
        for (int i = 0; i < persons.length; i++) {
            listPersonWrapper[i].p.displayPersonInfo();
        }
    }
}

class PersonWrapper {

    Persons p;

    public PersonWrapper() {
    }

    public PersonWrapper(Persons p) {
        this.p = p;
    }
}
