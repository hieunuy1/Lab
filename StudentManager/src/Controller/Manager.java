package Controller;

import Model.Report;
import Model.Student;
import Validation.Validation;

import java.util.ArrayList;
import java.util.Collections;

public class Manager {

    public static void menu() {
        System.out.println(" 1. Create");
        System.out.println(" 2. Find and Sort");
        System.out.println(" 3. Update/Delete");
        System.out.println(" 4. Report");
        System.out.println(" 5. Exit");
        System.out.print(" Enter your choice: ");
    }

    public static void createStudent(int count, ArrayList<Student> s) {
        if (count > 10 && !Validation.checkInputYN("Do you want to continue (Y/N): ")) {
            return;
        }

        while (true) {
            String id = Validation.checkInputString("Enter id: ");
            String name = Validation.checkInputString("Enter name student: ");

            if (!Validation.checkIdDuplicated(s, id, name)) {
                System.err.println("Id has existed for a student. Please re-enter.");
                continue;
            }

            String semester = Validation.checkInputString("Enter semester: ");
            String course = Validation.checkInputCourse("Enter name course: ");

            if (Validation.isStudentNotExisting(s, id, name, semester, course)) {
                s.add(new Student(id, name, semester, course));
                count++;
                System.out.println("Student added successfully.");
                return;
            }

            System.err.println("Duplicate student information.");
        }
    }

    public static void findAndSort(ArrayList<Student> s) {
        if (s.isEmpty()) {
            System.err.println("List is empty.");
            return;
        }

        ArrayList<Student> listStudentFindByName = listStudentFindByName(s);

        if (listStudentFindByName.isEmpty()) {
            System.err.println("No students found.");
        } else {
            Collections.sort(listStudentFindByName);
            System.out.printf("%-15s%-15s%-15s\n", "Student name", "Semester", "Course Name");

            for (Student student : listStudentFindByName) {
                student.print();
            }
        }
    }

    public static ArrayList<Student> listStudentFindByName(ArrayList<Student> s) {
        ArrayList<Student> listStudentFindByName = new ArrayList<>();
        String name = Validation.checkInputString("Enter name to search: ");

        for (Student student : s) {
            if (student.getStudentName().contains(name)) {
                listStudentFindByName.add(student);
            }
        }

        return listStudentFindByName;
    }

    public static void updateOrDelete(int count, ArrayList<Student> s) {
        if (s.isEmpty()) {
            System.err.println("List is empty.");
            return;
        }

        String id = Validation.checkInputString("Enter id: ");
        ArrayList<Student> listStudentFindById = getListStudentById(s, id);

        if (listStudentFindById.isEmpty()) {
            System.err.println("No student found.");
            return;
        } else {
            Student student = getStudentByListFound(listStudentFindById);
            boolean isUpdate = Validation.checkInputUD("Do you want to update (U) or delete (D) student: ");

            if (isUpdate) {
                updateStudent(count, s, id, student);
            } else {
                deleteStudent(s, count, student);
            }
        }
    }

    private static void updateStudent(int count, ArrayList<Student> s, String id, Student student) {
        String idStudent = Validation.checkInputString("Enter id: ");
        String name = Validation.checkInputString("Enter name student: ");
        String semester = Validation.checkInputString("Enter semester: ");
        String course = Validation.checkInputCourse("Enter name course: ");

        if (!Validation.checkChangedInformation(student, id, name, semester, course)) {
            System.err.println("No changes made.");
        }

        if (Validation.isStudentNotExisting(s, id, name, semester, course)) {
            student.setId(idStudent);
            student.setStudentName(name);
            student.setSemester(semester);
            student.setCourseName(course);
            System.err.println("Update successful.");
        }
    }

    private static void deleteStudent(ArrayList<Student> s, int count, Student student) {
        s.remove(student);
        count--;
        System.err.println("Delete successful.");
    }

    public static Student getStudentByListFound(ArrayList<Student> listStudentFindById) {
        System.out.println("List of students found: ");
        int count = 1;
        System.out.printf("%-10s%-15s%-15s%-15s\n", "Number", "Student name",
                "Semester", "Course Name");

        for (Student student : listStudentFindById) {
            System.out.printf("%-10d%-15s%-15s%-15s\n", count,
                    student.getStudentName(), student.getSemester(),
                    student.getCourseName());
            count++;
        }

        int choice = Validation.checkInputIntLimit(1, listStudentFindById.size(), "Enter student: ");
        return listStudentFindById.get(choice - 1);
    }

    public static ArrayList<Student> getListStudentById(ArrayList<Student> s, String id) {
        ArrayList<Student> listStudentById = new ArrayList<>();
        for (Student student : s) {
            if (id.equalsIgnoreCase(student.getId())) {
                listStudentById.add(student);
            }
        }
        return listStudentById;
    }

    public static void report(ArrayList<Student> s) {
        if (s.isEmpty()) {
            System.err.println("List is empty.");
            return;
        }

        ArrayList<Report> lr = new ArrayList<>();
        int size = s.size();

        for (int i = 0; i < size; i++) {
            int total = 0;
            for (Student student : s) {
                String id = student.getId();
                String courseName = student.getCourseName();
                String studentName = student.getStudentName();
                for (Student studentCountTotal : s) {
                    if (id.equalsIgnoreCase(studentCountTotal.getId())
                            && courseName.equalsIgnoreCase(studentCountTotal.getCourseName())) {
                        total++;
                    }
                }
                if (Validation.checkReport(lr, studentName,
                        courseName, total)) {
                    lr.add(new Report(student.getStudentName(), studentName, total));
                }
            }
        }

        for (int i = 0; i < lr.size(); i++) {
            System.out.printf("%-15s|%-10s|%-5d\n", lr.get(i).getStudentName(),
                    lr.get(i).getCourseName(), lr.get(i).getTotalCourse());
        }
    }
}
