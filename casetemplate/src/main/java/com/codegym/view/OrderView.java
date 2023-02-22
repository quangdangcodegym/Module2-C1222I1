package com.codegym.view;

import com.codegym.service.inmemory.IMOrderService;
import com.codegym.model.Order;
import com.codegym.model.OrderItem;

import java.util.List;
import java.util.Scanner;

public class OrderView {
    private Scanner scanner = new Scanner(System.in);
    private IMOrderService orderService;

    public OrderView() {
        orderService = new IMOrderService();
    }
    public void showOrderView() {
        List<Order> orders = orderService.getAllOrders();
        for (int i = 0; i < orders.size(); i++) {
            System.out.println("Mã hóa đơn: " + orders.get(i).getId());
            System.out.println("Fullname: " + orders.get(i).getFullName());
            System.out.println("Phone: " + orders.get(i).getPhone());
            System.out.println("------------------------------");

            for (int j = 0; j < orders.get(i).getOrderItems().size(); j++) {
                OrderItem orderItem = orders.get(i).getOrderItems().get(j);
                System.out.printf("%10s %10s %5s %10s", orderItem.getIdProduct(), orderItem.getPrice(), orderItem.getQuantity(),
                        orderItem.getPrice()*orderItem.getQuantity());
                System.out.println();
            }

        }
    }

    public void launcher() {
        boolean checkActionMenu = false;
        do {
            System.out.println("Menu quản lý hóa đơn");
            System.out.println("1. Xem danh sách hóa đơn");
            System.out.println("2. Thêm hóa đơn");

            int actionMenu = Integer.parseInt(scanner.nextLine());
            switch (actionMenu) {
                case 1:
                    showOrderView();
                    break;
                default:
                    System.out.println("Nhập không đúng vui lòng nhập lại");
                    checkActionMenu = true;
                    continue;
            }
            boolean checkActionMenuContinue = false;
            do{
                checkActionMenuContinue = false;
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
