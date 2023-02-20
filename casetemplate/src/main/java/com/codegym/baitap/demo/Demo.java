package com.codegym.baitap.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        int []arr = {4, 12, 7, 8, 1, 6, 9};
//        int index = minValue(arr);
//        System.out.println("The smallest element is: " + arr[index]);
    }
    public void demoDate() {
        String sD2 = "20-02-2023 08:30";

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm");
        try {
            Date d2 = formatter.parse(sD2);
            System.out.println(d2);


            System.out.println(formatter.format(d2));

        } catch (ParseException parseException) {
            parseException.printStackTrace();
        }
    }
}
