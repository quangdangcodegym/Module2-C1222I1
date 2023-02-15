package com.codegym;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        ShopManager shopManager = new ShopManager();

        boolean checkActionMenu = true;
        do {
            System.out.println("Menu quản lý sản phẩm");
            System.out.println("1. Xem danh sách");
            System.out.println("2. Thêm sản phẩm");
            System.out.println("3. Xóa sản phẩm");
            System.out.println("4. Cập nhật sản phẩm");
            int actionMenu = Integer.parseInt(scanner.nextLine());
            switch (actionMenu) {
                case 1:
                    shopManager.showProductsView();
                    break;
                case 3:
                    shopManager.deleteProductView();
                    break;
                default:
                    System.out.println("Nhập không đúng vui lòng nhập lại");
                    continue;
            }
            System.out.println("Bạn có muốn tiếp tục hay không Yes(Y)/No(N)");
            String actionMenuContinue = scanner.nextLine();
            switch (actionMenuContinue) {
                case "Y":
                    checkActionMenu = true;
                    break;
                case "N":
                    checkActionMenu = false;
                    break;
            }
        } while (checkActionMenu);

    }
}
