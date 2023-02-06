package com.codegym.oopextends;

import java.util.Objects;

public class MainApp {



    public static void main(String[] args) {
//        Circle circle1 = new Circle();
//        Circle circle2 = new Circle("RED", true);
//
//        System.out.println(circle1.toString());
//        System.out.println(circle2.toString());

        Geometric g1 = new Rectangle(4.0, 5.0, "RED", false);
        Geometric g2 = new Circle(2.0f, "YELLOW", true);

        Rectangle r1 = new Rectangle(4.0, 5.0, "BLUE", false);


        if (r1 instanceof Rectangle) {
            System.out.println("R1 là 1 thể hiện của Rectangle");
        }
        if (r1 instanceof Geometric) {
            System.out.println("R1 là 1 thể hiện của Geometric");
        }
        if (g1 instanceof Circle) {
            System.out.println("R1 là 1 thể hiện của Circle");
        }


        showGeometric(r1);
//        System.out.println(g1.getColor());

    }

    public static void showGeometric(Geometric geometric) {
        System.out.println("Thông tin màu sắc của hình: ");
        System.out.println(geometric.getColor());
    }
}
