/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import java.util.regex.Pattern;

/**
 *
 * @author Windows
 */
public class Validation {

    public static void validateFruitId(String fruitId) throws IllegalArgumentException {
        if (!isInteger(fruitId)) {
            throw new IllegalArgumentException("Fruit Id must be a numeric value.");
        }
    }

    public static void validatePrice(String price) throws IllegalArgumentException {
        if (!isNumeric(price)) {
            throw new IllegalArgumentException("Price must be a numeric value.");
        }
    }

    public static void validateQuantity(String quantity) throws IllegalArgumentException {
        if (!isInteger(quantity)) {
            throw new IllegalArgumentException("Quantity must be a numeric value.");
        }
    }

    public static void validateName(String name) throws IllegalArgumentException {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name must not be empty.");
        }
    }

    private static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    // Thêm phương thức mới kiểm tra xem chuỗi có thể chuyển đổi thành số nguyên hay không
    private static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}