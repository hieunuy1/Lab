/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Manager;

/**
 *
 * @author Windows
 */
 public class Validation extends Library {
    public String checkInputString(String prompt) {
        while (true) {
            String result = getString(prompt);
            if (!result.isEmpty()) {
                return result;
            }
            System.err.println("Input cannot be empty.");
        }
    }

    public boolean checkInputYN(String prompt) {
        while (true) {
            char result = getChar(prompt);
            if (result == 'Y' || result == 'y') {
                return true;
            } else if (result == 'N' || result == 'n') {
                return false;
            }
            System.err.println("Invalid input. Please enter Y or N.");
        }
    }

    public float checkInputFloat(String prompt) {
        while (true) {
            try {
                float result = Float.parseFloat(getString(prompt));
                return result;
            } catch (NumberFormatException ex) {
                System.err.println("Invalid input. Please enter a valid floating-point number.");
            }
        }
    }
}
