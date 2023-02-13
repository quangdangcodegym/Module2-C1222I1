package com.codegym.dsa;

import java.util.*;

public class DSAMain {
    public static void main(String[] args) {


        ArrayList<String> tens = new ArrayList<>();
        tens.add("Anh Khoa");
        tens.add("Anh Minh");
        tens.add("Anh Cu");
        printArray(tens);


        // 1 biến của lớp cha tham chiếu tới đối tượng của lớp con
        List<String> sinhviens = new ArrayList<>();

        sinhviens.add("Quang DAng");
        sinhviens.add("Long Van");
        sinhviens.add("Sinh Nhat");
//        sinhviens.remove(1);
        System.out.println("Size danh sach: " + sinhviens.size());  // size: 3
        System.out.println("Lay phan tu thu 1: " + sinhviens.get(1)); // Long Van
        // [Quang DAng, Sinh Nhat]
//        System.out.println(sinhviens);
        printArray(sinhviens);




        Set<String> products = new HashSet<>();
        products.add("Iphone x");
        products.add("Iphone 11");
        products.add("Iphone x");
        System.out.println(products);

        Iterator<String> iterator = products.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public static void printArray(List<String> danhsach) {
        for (int i = 0; i < danhsach.size(); i++) {
            System.out.println("Item " + i + " :" + danhsach.get(i));
        }
    }
}
