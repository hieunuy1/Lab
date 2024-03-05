/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Validation;

import Model.Student;
import Model.Report;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Windows
 */
public class Validation {
    private final static Scanner in = new Scanner(System.in);

     public static int checkInputIntLimit(int min, int max, String prompt) {
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in range [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    public static String checkInputString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty");
            } else {
                return result;
            }
        }
    }

    public static boolean checkInputYN(String prompt) {
        while (true) {
            String result = checkInputString(prompt);
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }
            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please input Y/N.");
            System.out.print("Enter again: ");
        }
    }

    public static boolean checkInputUD(String prompt) {
        while (true) {
            String result = checkInputString(prompt);
            if (result.equalsIgnoreCase("U")) {
                return true;
            }
            if (result.equalsIgnoreCase("D")) {
                return false;
            }
            System.err.println("Please input U/D.");
            System.out.print("Enter again: ");
        }
    }

    public static String checkInputCourse(String prompt) {
        while (true) {
            String result = checkInputString(prompt);
            if (result.equalsIgnoreCase("java") || result.equalsIgnoreCase(".net") || result.equalsIgnoreCase("c/c++")) {
                return result;
            }
            System.err.println("There are only three courses: Java, .Net, C/C++");
            System.out.print("Enter again: ");
        }
    }

    public static boolean isStudentNotExisting(ArrayList<Student> students, String id, String studentName, String semester, String courseName) {
        for (Student student : students) {
            if (id.equalsIgnoreCase(student.getId()) && studentName.equalsIgnoreCase(student.getStudentName())
                    && semester.equalsIgnoreCase(student.getSemester()) && courseName.equalsIgnoreCase(student.getCourseName())) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkReport(ArrayList<Report> reports, String name, String course, int total) {
        for (Report report : reports) {
            if (name.equalsIgnoreCase(report.getStudentName()) && course.equalsIgnoreCase(report.getCourseName())
                    && total == report.getTotalCourse()) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkIdDuplicated(ArrayList<Student> students, String id, String name) {
        for (Student student : students) {
            if (id.equalsIgnoreCase(student.getId()) && !name.equalsIgnoreCase(student.getStudentName())) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkChangedInformation(Student student, String id, String name, String semester, String course) {
        return id.equalsIgnoreCase(student.getId()) && name.equalsIgnoreCase(student.getStudentName())
                && semester.equalsIgnoreCase(student.getSemester()) && course.equalsIgnoreCase(student.getCourseName());
    }
}