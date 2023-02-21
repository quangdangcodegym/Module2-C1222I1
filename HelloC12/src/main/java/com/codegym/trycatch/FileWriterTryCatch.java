package com.codegym.trycatch;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileWriterTryCatch {
    private static Scanner scanner = new Scanner(System.in);
    public void writeFile() throws FileNotFoundException, ArithmeticException, Chia0Exception{
        File file = new File("C12.txt");

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        if (b == 0) {
            throw new Chia0Exception("Loi chia cho 0 đó bạn nghe");
//            System.out.println(a / b);

        }

        PrintWriter printWriter = new PrintWriter(file);
        System.out.println("End ..");
    }
}
