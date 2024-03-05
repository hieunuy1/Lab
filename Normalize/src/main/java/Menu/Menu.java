package Menu;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author gabri
 */
import java.util.Scanner;
import Model.Document;
import Controller.Controller;
import java.io.IOException;
public abstract class Menu {
    private final Scanner scanner;
    private final Controller documentController;
    private final String filePath = "D:\\normalize\\"; 

    public Menu() {
        scanner = new Scanner(System.in);
        documentController = new Controller();
    }

    public void run() {
        try (scanner) {
            boolean exit = false;
            while (!exit) {
                displayMenu();
                int choice = getUserChoice();
                switch (choice) {
                    case 1 -> normalizeDocument();
                    case 2 -> exit = true;
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }

    private void displayMenu() {
        System.out.println("1. Normalize Document");
        System.out.println("2. Exit");
    }

    private int getUserChoice() {
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); 
        System.out.println();
        return choice;
    }

    private void normalizeDocument() {
        System.out.print("Enter the input file name: ");
        String inputFileName = scanner.nextLine().trim();
        String inputFileFullPath = filePath + inputFileName;
        System.out.print("Enter the output file name: ");
        String outputFileName = scanner.nextLine().trim();
        String outputFileFullPath = filePath + outputFileName;
        System.out.println();

        try {
            Document document = documentController.readDocument(inputFileFullPath);
            documentController.normalizeDocument(document);
            documentController.writeDocument(document, outputFileFullPath);
            System.out.println("Document normalized and written to " + outputFileFullPath);
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
        System.out.println();
    }
}