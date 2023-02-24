package com.codegym;

import com.codegym.view.CustomerView;
import com.codegym.view.ProductView;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public void mainMenu() {
        boolean checkMainMenuManager = false;
        do {
            System.out.println("Menu quản lý");
            System.out.println("1.Quản lý khách hàng");
            System.out.println("2.Quản lý sản phẩm");
            System.out.println("3.Quản lý order");
            int mainMenu = Integer.parseInt(scanner.nextLine());
            switch (mainMenu) {
                case 1:
                    CustomerView customerView = new CustomerView();
                    customerView.launcher();
                    break;
                case 2:
                    ProductView productView = new ProductView();
                    productView.launcher();
                    break;
                case 3:
//                    OrderView orderView = new OrderView();
//                    orderView.laucher();
                    break;
                default:
                    System.out.println("Nhập không đúng vui lòng nhập lại: ");
                    checkMainMenuManager = true;
                    continue;
            }
            boolean checkActionMenuContinue = false;
            do{
                checkActionMenuContinue = false;
                System.out.println("Bạn có muốn tiếp tục hay không Yes(Y)/No(N)");
                String actionMenuContinue = scanner.nextLine();
                switch (actionMenuContinue) {
                    case "Y":
                        checkMainMenuManager = true;
                        break;
                    case "N":
                        checkMainMenuManager = false;
                        break;
                    default:
                        System.out.println("Nhập không không đúng vui lòng nhập lai");
                        checkActionMenuContinue = true;

                }
            }while (checkActionMenuContinue);
        }while (checkMainMenuManager);
    }
    public static void main(String[] args) {
        Main main = new Main();
        main.mainMenu();
    }
}
