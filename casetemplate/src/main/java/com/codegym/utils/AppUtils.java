package com.codegym.utils;

public class AppUtils {
    public static long getLastFiveDigits(long number) {
        long lastFiveDigits = 0;
        for (int i = 0; i < 5; i++) {
            lastFiveDigits = lastFiveDigits * 10 + number % 10;
            number /= 10;
        }
        return lastFiveDigits;
    }
}
