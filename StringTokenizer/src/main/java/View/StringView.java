/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author tung
 */
public class StringView {
    private Scanner scanner;

    public StringView() {
        scanner = new Scanner(System.in);
    }

    public int displayMenu() {
        System.out.println("1. Count word occurrences");
        System.out.println("2. Count letter occurrences");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    public String getUserInput() {
        scanner.nextLine(); // Consume newline character
        System.out.print("Enter a string: ");
        return scanner.nextLine();
    }

    public void displayWordOccurrences(Map<String, Integer> wordCount) {
        System.out.println("Word occurrences: " + wordCount);
    }

    public void displayLetterOccurrences(Map<Character, Integer> letterCount) {
        System.out.println("Letter occurrences: " + letterCount);
    }
}