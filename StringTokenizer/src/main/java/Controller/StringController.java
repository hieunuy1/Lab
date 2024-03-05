/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.util.Map;
import Model.StringModel;
import View.StringView;

/**
 *
 * @author tung
 */
class StringController {
    private StringModel model;
    private StringView view;

    public StringController(StringModel model, StringView view) {
        this.model = model;
        this.view = view;
    }

    public void processUserInput() {
        boolean exit = false;
        while (!exit) {
            int choice = view.displayMenu();
            switch (choice) {
                case 1:
                    String userInput = view.getUserInput();
                    model.setInputString(userInput);
                    Map<String, Integer> wordCount = model.countWordOccurrences();
                    view.displayWordOccurrences(wordCount);
                    break;
                case 2:
                    userInput = view.getUserInput();
                    model.setInputString(userInput);
                    Map<Character, Integer> letterCount = model.countLetterOccurrences();
                    view.displayLetterOccurrences(letterCount);
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
