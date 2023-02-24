package com.codegym.cleancode;

public class TachHang {
    public static boolean isAuthorized(int role) {
        if (role == 1) {
            return true;
        }
        return false;
    }

    public static final int ROLE_ADMIN = 1;
//    public static boolean isAuthorized(int role) {
//        if (role == ROLE_ADMIN) {
//            return true;
//
//        }
//    }
}
