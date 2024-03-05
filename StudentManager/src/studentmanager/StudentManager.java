/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package studentmanager;
import Controller.Manager;
import Validation.Validation;
import Model.Student;
import java.util.ArrayList;
/**
 *
 * @author Windows
 */
public class StudentManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Student> s = new ArrayList<>();
        Validation validation = new Validation();
      
        int count = 0;
        while (true) {
            Manager.menu();
            int choice = validation.checkInputIntLimit(1, 5, "Enter student: ");
            switch (choice) {
                case 1:
                    Manager.createStudent(count, s);
                    break;
                case 2:
                    Manager.findAndSort(s);
                    break;
                case 3:
                    Manager.updateOrDelete(count, s);
                    break;
                case 4:
                    Manager.report(s);
                    break;
                case 5:
                    return;
            }

        }
    }
    
}
