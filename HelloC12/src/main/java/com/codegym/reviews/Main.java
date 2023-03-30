package com.codegym.reviews;

public class Main {
    public static void main(String[] args) {
        int a = 2;

        a = a++ > 3 ? 3 : 2;
        switch (++a){
            case 2:
                System.out.println("2");
                break;
            case 3:
                System.out.println(3);
            default:
                System.out.println("default");
        }

    }
}
