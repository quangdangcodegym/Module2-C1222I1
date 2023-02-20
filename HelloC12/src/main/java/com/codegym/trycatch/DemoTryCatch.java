package com.codegym.trycatch;

import java.util.Scanner;

public class DemoTryCatch {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        readNumber();

    }
    public static int readNumber() {
        String sNumber = scanner.nextLine();

        // sNumber = 2, "aa"
        int number = 0;
        try {
            number = Integer.parseInt(sNumber);
        } catch (Exception e) {
            System.out.println("Exception");
            return 10;
        }finally {
            System.out.println("Finally");
        }
        return number;
    }
}
