package com.codegym.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    private static  SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm");
    public static  String dateToString(Date date) {
            return formatter.format(date);
    }
    public static  Date parseDate(String sDate) {
        try {
            return formatter.parse(sDate);
        } catch (ParseException parseException) {
            parseException.printStackTrace();
        }
        return null;
    }
}
