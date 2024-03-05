/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 *
 * @author tung
 */
public class StringModel {
    private String inputString;

    public void setInputString(String inputString) {
        this.inputString = inputString;
    }

    public Map<String, Integer> countWordOccurrences() {
        Map<String, Integer> wordCount = new HashMap<>();
        StringTokenizer tokenizer = new StringTokenizer(inputString, " ");
        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken();
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        return wordCount;
    }

    public Map<Character, Integer> countLetterOccurrences() {
        Map<Character, Integer> letterCount = new HashMap<>();
        StringTokenizer tokenizer = new StringTokenizer(inputString, " ");
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            for (int i = 0; i < token.length(); i++) {
                char letter = token.charAt(i);
                if (Character.isLetter(letter)) {
                    letter = Character.toLowerCase(letter);
                    letterCount.put(letter, letterCount.getOrDefault(letter, 0) + 1);
                }
            }
        }
        return letterCount;
    }
}
