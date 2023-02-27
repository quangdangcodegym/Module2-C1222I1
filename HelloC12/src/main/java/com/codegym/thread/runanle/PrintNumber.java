package com.codegym.thread.runanle;

public class PrintNumber implements Runnable{

    private int lastNumber;
    public PrintNumber(int number) {
        lastNumber = number;
    }
    @Override
    public void run() {
        for (int i = 0; i < lastNumber; i++) {
            System.out.println("Number " + i);
        }
    }
}
