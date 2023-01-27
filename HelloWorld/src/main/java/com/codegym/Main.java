package com.codegym;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        /**
        System.out.println("Hello C12");    // println là in xuống dòng
        System.out.print("Hell0 A nhat");   // print không có xuống dòng
        System.out.print("Hell0 A LUC");

         **/


        System.out.println("Nhập tuổi của học sinh");
        int age = scanner.nextInt();
        System.out.println("Age: " + age);
    }
}