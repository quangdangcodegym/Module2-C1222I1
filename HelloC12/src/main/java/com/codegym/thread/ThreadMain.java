package com.codegym.thread;

import com.codegym.thread.runanle.PrintChar;
import com.codegym.thread.runanle.PrintNumber;
import com.codegym.thread.thread.TPrintChar;
import com.codegym.thread.thread.TPrintNumber;

public class ThreadMain {
    public static void main(String[] args) {


    }
    public void createThreadUseImplementsRunnable() {
        PrintChar printChar = new PrintChar(100, 'a');
        PrintChar printChar1 = new PrintChar(100, 'b');


        PrintNumber printNumber = new PrintNumber(50);



        Thread t1 = new Thread(printChar);
        Thread t2 = new Thread(printChar1);
        Thread t3 = new Thread(printNumber);

        t1.start();
        t2.start();
        t3.start();

    }
    public void createThreadUseExtendThread(){
        Thread t1 = new TPrintChar(100, 'a');
        Thread t2 = new TPrintChar(100, 'b');

        Thread t3 = new TPrintNumber(50);


        t1.start();
        t2.start();
        t3.start();
    }
    public void createThreadUseAnonymousClass() {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("E");
                }
            }
        };
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("D");
                }
            }
        });
        t1.start();

        Thread t2 = new Thread(r1);
        t2.start();


        Thread t11 = new Thread() {
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("F");
                }
            }
        };

    }

}
