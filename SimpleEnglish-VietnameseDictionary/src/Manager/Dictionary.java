/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Manager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Windows
 */
public class Dictionary {

    private Map<String, String> dict;

    public Dictionary() {
        dict = new HashMap<>();
    }

    public void loadData() throws FileNotFoundException, IOException {
        File f = new File("dictionary.txt");
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        while (true) {
            String line = br.readLine();
            if (line == null || line.isEmpty()) {
                break;
            }
            String[] words = line.split("[-]");
            String eng = words[0].trim(), vi = words[1].trim();
            dict.put(eng, vi);
            
        }
        br.close();
        fr.close();
    }

    public void saveData() throws IOException {
        File f = new File("dictionary.txt");
        FileWriter fw = new FileWriter(f);
        BufferedWriter bw = new BufferedWriter(fw);
        for (Map.Entry<String, String> entry : dict.entrySet()) {
            bw.write(entry.getKey() + " - " + entry.getValue() + "\n");
        }
        
        bw.close();
        fw.close();
    }
    
    public void addWord() throws IOException {
        String eng = Validation.getString("Enter English");
        if (dict.containsKey(eng) && !Validation.getYN(eng + " is already existed in dictionary, do you want to update(Y/N).")) {
            return;
        }
        String vi = Validation.getString("Enter Vietnamese:");
        dict.put(eng, vi);
        saveData();
        System.out.print("Add successfull.");
    }

    public void removeWord() throws IOException {
        String eng = Validation.getString("Enter English:");
        if (!dict.containsKey(eng)) {
            System.err.print("Not found.");
            return;
        }
        dict.remove(eng);
        saveData();
        System.out.print("Delete successfull.");
    }

    public void translate() {
        String eng = Validation.getString("Enter English:");
        if (!dict.containsKey(eng)) {
            System.out.print("Not found.");
            return;
        }
        System.out.print("Vietnamese: " + dict.get(eng));
    }
}
