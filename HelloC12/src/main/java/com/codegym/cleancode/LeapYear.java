package com.codegym.cleancode;

public class LeapYear {
    private static boolean isLeapYear(int year) {
        if(year % 4 == 0){
            if (year % 100 == 0){
                if(year % 400 == 0)
                    return true;
            } else {
                return true;
            }
        }
        return false;
    }
//    private static boolean isLeapYear(int year) {
//        boolean isDivisibleBy4 = year % 4 == 0;
//        if(isDivisibleBy4){
//            boolean isDivisibleBy100 = year % 100 == 0;
//            if (isDivisibleBy100){
//                boolean isDivisibleBy400 = year % 400 == 0;
//                if(isDivisibleBy400) return
//                        true;
//            } else {
//                return true;
//            }
//        }
//        return false;
//    }
}
