package com.codegym;

import java.util.Scanner;

public class CountDate {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        // 1, 3, 5, 7, 8, 10, 12
        /**
         System.out.println("Nhập vào tháng: ");   // Viết tắt: sout
         int month = scanner.nextInt();              // nextInt(): nhâp vào 1 số nguyên
        if(month == 1 || month==3 || month==5 || month ==7 ||
            month ==8 || month==10 || month==12){
            System.out.println("Tháng " + month + " có 31 ngày");
        }else if(month==2){
            System.out.println("Tháng " + month + " có 28 hoặc 29 ngày");
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            System.out.println("Tháng " + month + " có 30 ngày");
        }else{
            System.out.println("Tháng không hợp lệ");
        }

         **/

        boolean checkMenuAction = true;
        do{
            System.out.println("Nhập vào tháng: ");   // Viết tắt: sout
            int month = scanner.nextInt();
            checkDateOfMonth(month);

            System.out.println("Ban có muốn tiếp tục hay không tiếp tục (1) Dừng (0): ");
            int action = scanner.nextInt();
            switch (action) {
                case 1:
                    checkMenuAction = true;
                    break;
                case 0:
                    checkMenuAction = false;
                    break;
                default:

            }
        }while (checkMenuAction);
    }
    public static void checkDateOfMonth(int month) {
        switch (month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                //System.out.println("Tháng " + month + " có 31 ngày");
                // String literal ở module 1:  `Tháng ${month} có ${31} ngày`
                System.out.printf("Tháng %s có %s ngày \n", month, 31);
                break;
            case 2:
                System.out.printf("Tháng %s có có 28 hoặc 29 ngày \n", month);
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println("Tháng " + month + " có 30 ngày");
                break;
            default:
                System.out.println("Tháng không hợp lệ");
        }
    }

    public static int sum(int a, int b) {
        int c = a  + b;

        return c;
    }

}
