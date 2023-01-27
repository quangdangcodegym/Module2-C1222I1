package com.codegym;

import java.util.Scanner;

public class LinearEquationResolver {

    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Giải phương trình bậc nhất: ax + b = 0");

        System.out.println("Nhập a đi: ");
        int a = scanner.nextInt();
        System.out.println("Nhâp b đi: ");
        int b = scanner.nextInt();

        // a = 2, b = 7
         float x = (-b * 1.0f) / a;


        System.out.println("Nghiệm của phương trình là: " + x);
    }
}
