package com.codegym.cleancode;

public class CleanCodeMain {
    public static int getDaysOfMonth(int month, int year) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                boolean isLeapYear = false;
                if (year % 4 == 0) {
                    if (year % 100 == 0) {
                        if (year % 400 == 0)
                            isLeapYear = true;
                    } else {
                        isLeapYear = true;
                    }
                    if (isLeapYear) {
                        return 29;
                    } else {
                        return 28;
                    }
                }
            default:
                return 0;
        }
    }
    private static boolean isLeapYear(int year) {
        boolean isLeapYear =false;
        if(year % 4 == 0){
            if (year % 100 == 0){
                if(year % 400 == 0)
                    isLeapYear = true;
            } else {
                isLeapYear = true;
            }
        }
        return isLeapYear;
    }
}
