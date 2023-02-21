package com.codegym.trycatch;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        FileWriterTryCatch fileWriter = new FileWriterTryCatch();
        try {
            fileWriter.writeFile();
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("");
        } catch (ArithmeticException arithmeticException) {
            System.out.println("Loi chia cho /0");
//            arithmeticException.printStackTrace();
        } catch (Chia0Exception chia0Exception) {
            System.out.println(chia0Exception.getMessage());
        }

    }
}
