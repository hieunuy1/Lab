/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Manager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import object.SalaryHistory;
import object.Worker;

/**
 *
 * @author gabri
 */
public class Management {

    final double epsi = 0.000001;

    private Scanner sc = new Scanner(System.in);
    private List<Worker> wList;
    private List<SalaryHistory> shList;

    public Management() {
        wList = new ArrayList<>();
        shList= new ArrayList<>();
    }

    public void addWorker() {
        String id, name, workLocation;
        int age;
        double salary;
        id = Validation.getCode("Enter worker id: ", "ID should be unique and not null", wList, 1);
        System.out.println("Enter worker name: ");
        name = sc.nextLine();
        age = Validation.getInt("Enter worker age:", 18, 60);
        salary = Validation.getDouble("ENter worker salary: ", epsi, Double.MAX_VALUE);
        System.out.print("Enter work location: ");
        workLocation = sc.nextLine();
        wList.add(new Worker(id, name, age, salary, workLocation));
    }

    public void updateSalary(int mode) {
        String id = Validation.getCode("Enter worker id to be updated: ", " ID must ẽist in database and not null", wList, 2);
String status ="";
        double money = Validation.getDouble("Amount of money: ", epsi, Double.MAX_VALUE);
        Worker o = Validation.getWorker(id, wList);
        double update = 0;
        if (mode == 1) {
            update = o.getSalary() + money;
            status = "up";
        } else if (mode == 2) {
            if (o.getSalary() > money) {
                update = o.getSalary() - money;
                status = "down";
            }
        }
        o.setSalary(update);
        shList.add(new SalaryHistory(id, o.getName(), o.getAge(),o.getSalary(),status,LocalDate.now()));
    }

    public void getInformation() {
        display(shList);
    }

    public void displayAll() {
        display(wList);
    }

    public void display(List list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }
}
