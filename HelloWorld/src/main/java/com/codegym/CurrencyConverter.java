package com.codegym;

import java.util.Scanner;

public class CurrencyConverter {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Chương trình chuyển đồi tiền tệ: ");
        // menu: USD-VND, VND-USD
        String menu = scanner.nextLine();
        System.out.println("Nhập số tiền: ");
        float money  = scanner.nextFloat();
        float total = 0;

        /**
        if(menu.equals("USD-VND")){
            total = money * 23000;
        }else if (menu.equals("VND-USD")){
            total = money / 23000;
        }
         **/

        switch (menu) {
            case "USD-VND":
                total = money * 23000;
                break;
            case "VND-USD":
                total = money / 23000;
        }

        System.out.println("Kết quả tui chuyển nè: " + total);
    }
}
