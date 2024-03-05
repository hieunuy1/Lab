/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.io.IOException;
import Model.Document;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

/**
 *
 * @author gabri
 */
public class Controller {

    public Document readDocument(String filename) throws IOException {
        Document document = new Document();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                document.addLine(line);
            }
        }
        return document;
    }

    public void normalizeDocument(Document document) {
        List<String> lines = document.getLines();

        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);

            line = line.trim();

            line = line.replaceAll("\\s+", " ");

            line = normalizeSentences(line);

            lines.set(i, line);
        }
    }

    private String normalizeSentences(String line) {
        line = line.replaceAll("\\s*\"\\s*", "\"");
        line = line.replaceAll("\\s*\\.\\s*", ".");
        line = line.replaceAll("\\s*\\,\\s*", ",");
        line = line.replaceAll("\\s*:\\s*", ":");

        if (!line.endsWith(".")) {
            line += ".";
        }

        StringBuilder sb = new StringBuilder();
        boolean capitalizeNext = true;
        for (char c : line.toCharArray()) {
            if (Character.isLetter(c)) {
                if (capitalizeNext) {
                    c = Character.toUpperCase(c);
                    capitalizeNext = false;
                } else {
                    c = Character.toLowerCase(c);
                }
            } else if (c == '.') {
                capitalizeNext = true;
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public void writeDocument(Document document, String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            List<String> lines = document.getLines();
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        }
    }
}
