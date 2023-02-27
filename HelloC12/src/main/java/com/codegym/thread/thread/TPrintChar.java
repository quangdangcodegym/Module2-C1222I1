package com.codegym.thread.thread;

public class TPrintChar extends Thread{
    private int times;
    private char cToPrint;

    public TPrintChar(int times, char cToPrint) {
        this.times = times;
        this.cToPrint = cToPrint;
    }
    @Override
    public void run() {
        for (int i = 0; i < times; i++) {
            System.out.println(cToPrint);
        }
    }
}
