/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import Model.Circle;
import Model.Rectangle;
import Model.Shape;
import Model.Triangle;

/**
 *
 * @author tung
 */
public class View {
    public void printShapeDetails(Shape shape) {
        if (shape instanceof Triangle) {
            System.out.println("Triangle Details:");
        } else if (shape instanceof Rectangle) {
            System.out.println("Rectangle Details:");
        } else if (shape instanceof Circle) {
            System.out.println("Circle Details:");
        }
        shape.printResult();
    }
}