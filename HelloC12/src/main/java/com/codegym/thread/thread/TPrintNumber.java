package com.codegym.thread.thread;

public class TPrintNumber extends Thread{
    private int lastNumber;
    public TPrintNumber(int number) {
        lastNumber = number;
    }
    @Override
    public void run() {
        for (int i = 0; i < lastNumber; i++) {
            System.out.println("Number " + i);
        }
    }
}

