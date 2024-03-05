/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author Windows
 */
public class CheckInput {

    private final Scanner scanner = new Scanner(System.in);
    private final String PHONE_VALID_REGEX = "^\\d{10}$";
    private final String EMAIL_VALID_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}$";
    private final Pattern PHONE_PATTERN = Pattern.compile(PHONE_VALID_REGEX);
    private final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_VALID_REGEX);

    public CheckInput() {
    }

    private String checkInputString() {
        while (true) {
            String result = scanner.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Input cannot be empty.");
            } else {
                return result;
            }
        }
    }

    public String checkInputPhone() {
        while (true) {
                    System.out.print("Phone number:");
            String input = checkInputString();
            if (PHONE_PATTERN.matcher(input).matches()) {
                return input;
            } else {
                System.err.println("Phone number must be 10 digits");
            }
        }
    }

    public String checkInputDate() {
        while (true) {
                    System.out.print("Date: ");

            String dateCheck = checkInputString();
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                dateFormat.setLenient(false); // Strict date parsing
                dateFormat.parse(dateCheck);
                return dateCheck;
            } catch (ParseException e) {
                System.err.println("Invalid date format. Please use dd/MM/yyyy");
            }
        }
    }

    public String checkInputEmail() {
        while (true) {
                    System.out.print("Email: ");

            String emailCheck = checkInputString();
            if (EMAIL_PATTERN.matcher(emailCheck).matches()) {
                return emailCheck;
            } else {
                System.err.println("Email must be in the correct format");
            }
        }
    }
}
