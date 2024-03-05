/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentsort;

import Manager.StudentManager;
import Manager.Validation;
import java.util.ArrayList;
import object.Student;

/**
 *
 * @author Windows
 */
public class Manager {
    
    private StudentManager studentManager;
    private Validation validation;

    public Manager() {
        this.studentManager = new StudentManager();
        this.validation = new Validation();
    }

    

    public void display() {
        displayMenu();}
   
    public void displayMenu() {
        ArrayList<Student> students = new ArrayList<>();
        studentManager.addStudent(students);
        while (true) {
            System.out.print("Do you want to enter more student information?(Y/N): ");
            if (validation.checkInputYN("Please enter Y/N!!!")) {
                studentManager.addStudent(students);
            } else {
                break;
            }
        }
        studentManager.print(students);
    }
}

