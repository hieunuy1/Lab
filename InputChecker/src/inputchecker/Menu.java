/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inputchecker;

import Validation.CheckInput;

/**
 *
 * @author Windows
 */
public class Menu {

    CheckInput check = new CheckInput();

    public void display() {
        System.out.println("=========Validate Program=========");
        String phone = check.checkInputPhone();

        String email = check.checkInputEmail();

        String date = check.checkInputDate();
    }
}
