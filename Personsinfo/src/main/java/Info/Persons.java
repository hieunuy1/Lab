/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Info;

/**
 *
 * @author tung
 */
public class Persons {

    String name;
    String address;
    double salary;

    public Persons() {
    }

    public Persons(String name, String address, double salary) {
        this.name = name;
        this.address = address;
        this.salary = salary;
    }

    void displayPersonInfo() {
        System.out.println("Name: " + this.name);
        System.out.println("Address: " + this.address);
        System.out.println("Salary: " + this.salary);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

}