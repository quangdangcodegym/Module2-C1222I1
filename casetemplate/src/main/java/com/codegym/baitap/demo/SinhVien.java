package com.codegym.baitap.demo;

import java.lang.reflect.InvocationTargetException;

public class SinhVien {
    private String name;
    private int age;
    public SinhVien() {
        System.out.println("Goi khoi tao doi sinh vien");
    }

    public static void main(String[] args) {
//        SinhVien sv = new SinhVien();

            initSinhVien(SinhVien.class);

    }
    public static <T> void initSinhVien(Class<T> tClass){
        try {
            T obj = tClass.getDeclaredConstructor().newInstance();


        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
