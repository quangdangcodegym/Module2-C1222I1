package com.codegym;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        ShopManager shopManager = new ShopManager();

        boolean checkActionMenu = false;
        do {
            System.out.println("Menu quản lý sản phẩm");
            System.out.println("1. Xem danh sách");
            System.out.println("2. Thêm sản phẩm");
            System.out.println("3. Xóa sản phẩm");
            System.out.println("4. Cập nhật sản phẩm");
            System.out.println("5. Sắp xếp sản phẩm theo giá");
            System.out.println("6. Sắp xếp sản phẩm theo tên");         // bài 1
//            System.out.println("7. Sắp xếp sản phẩm theo ngày");
            System.out.println("8. Tìm kiếm sản phẩm theo tên");
            System.out.println("9. Tìm kiếm sản phẩm theo khoảng giá  (từ giá mấy đến giá mấy đó)");     // bài 2
            System.out.println("9. Tìm kiếm sản phẩm theo tên hoặc giá hoặc theo mô tả");   // bài 3
            int actionMenu = Integer.parseInt(scanner.nextLine());
            switch (actionMenu) {
                case 1:
                    shopManager.showProductsView(shopManager.getProducts());
                    break;
                case 3:
                    shopManager.deleteProductView();
                    break;
                case 5:
                    shopManager.sortProductByPriceView();
                    break;
                case 8:
                    shopManager.searchProductView();
                    break;
                default:
                    System.out.println("Nhập không đúng vui lòng nhập lại");
                    checkActionMenu = true;
                    continue;
            }
            boolean checkActionMenuContinue = false;
            do{
                System.out.println("Bạn có muốn tiếp tục hay không Yes(Y)/No(N)");
                String actionMenuContinue = scanner.nextLine();
                switch (actionMenuContinue) {
                    case "Y":
                        checkActionMenu = true;
                        break;
                    case "N":
                        checkActionMenu = false;
                        break;
                    default:
                        System.out.println("Nhập không không đúng vui lòng nhập lai");
                        checkActionMenuContinue = true;

                }
            }while (checkActionMenuContinue);

        } while (checkActionMenu);

    }
}
