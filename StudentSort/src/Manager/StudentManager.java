/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Manager;

import java.util.ArrayList;
import java.util.Collections;
import object.Student;
/**
 *
 * @author Windows
 */
public class StudentManager {
 private Validation validation;

    public StudentManager() {
        this.validation = new Validation();
    }

    public void addStudent(ArrayList<Student> students) {
        System.out.println("Please input student information ");
        String name = validation.checkInputString("Name: ");
        String classes = validation.checkInputString("Classes: ");
        float mark = validation.checkInputFloat("Mark: ");
        students.add(new Student(name, mark, classes));
    }

    public void print(ArrayList<Student> students) {
        if (students.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
        Collections.sort(students);
        for (int i = 0; i < students.size(); i++) {
            System.out.println("--------Student " + (i + 1) + "--------");
            System.out.println("Name: " + students.get(i).getName());
            System.out.println("Classes: " + students.get(i).getClasses());
            System.out.println("Mark: " + students.get(i).getMark());
        }
    }

}

