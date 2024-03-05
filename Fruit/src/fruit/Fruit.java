/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fruit;

import Controller.FruitShopController;
import View.Menu;

/**
 *
 * @author Windows
 */
public class Fruit {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FruitShopController controller = new FruitShopController();
        Menu menu = new Menu(controller);
        menu.run();
    }

}
