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

public class Main {
    public static void main(String[] args) {
        StringModel model = new StringModel();
        StringView view = new StringView();
        StringController controller = new StringController(model, view);
        controller.processUserInput();
    }
}