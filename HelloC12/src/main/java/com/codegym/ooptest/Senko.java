package com.codegym.ooptest;

import com.codegym.oop.Fan;

public class Senko {
    public static void main(String[] args) {

        /**
        Fan fan1 = new Fan(Fan.FAST, 5.0f, "XANH");
        Fan fan2 = new Fan(Fan.LOW, 5.5f, "DO");

        System.out.println(fan1.FAST);

        System.out.println(fan1.showFan());
        swapName(fan1, fan2);
        System.out.println( fan1.showFan());


        int a = 5;
        int b = 10;

        System.out.println("a: " + a);
        swapAB(a, b);
        System.out.println("a: " + a);

         **/

        Fan fan1 = new Fan(1, Fan.FAST, 5.0f, "XANH", 100000);
        Fan fan2 = new Fan(2, Fan.LOW, 5.0f, "DO", 105000);
        Fan fan3 = new Fan(3, Fan.FAST, 5.1f, "VANG", 105000);
        Fan fan4 = new Fan(4, Fan.LOW, 5.1f, "CAM", 100000);
        Fan fan5 = new Fan(5, Fan.LOW, 5.1f, "CAM", 100000);

        Fan[] fans = new Fan[5];
        fans[0] = fan1;
        fans[1] = fan2;
        fans[2] = fan3;
        fans[3] = fan4;
        fans[4] = fan5;

        showFans(fans);
        turnOnFans(fans);
        System.out.println("Sau khi bat het cac fan");
        showFans(fans);


        // Bài 1: Tìm cái quạt có đường kính lớn nhất
        // Bài 2: Lấy ra những cái quat nào có màu xanh
        // Bài 3: Tính tổng giá trị của công ty quạt
        // Bài 4: Thêm 1 cái quạt mới vào
    }

    public static void showFans(Fan[] fans) {
        for (int i = 0; i < fans.length; i++) {
            System.out.println(fans[i].showFan());
        }
    }

    public static void turnOnFans(Fan [] fans) {
        for (int i = 0; i < fans.length; i++) {
            fans[i].setOn(true);
        }
    }

    public static void swapAB(int x, int y) {
        int temp = x;
        x = y;
        y = temp;
    }
    public static void swapName(Fan a, Fan b) {
        String temp = a.getColor();
        a.setColor(b.getColor());

        b.setColor(temp);
    }

}
