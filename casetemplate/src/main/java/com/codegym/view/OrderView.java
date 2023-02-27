
package com.codegym.view;

import com.codegym.model.Order;
import com.codegym.model.OrderItem;
import com.codegym.model.Product;
import com.codegym.service.IOrderService;
import com.codegym.service.IProductService;
import com.codegym.service.file.FOrderService;
import com.codegym.service.file.FProductService;
import com.codegym.utils.DateUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class OrderView {
    private Scanner scanner = new Scanner(System.in);
    private IOrderService iOrderService;
    private IProductService iProductService;

    public OrderView() {
        iOrderService = new FOrderService();
        iProductService = new FProductService();
    }
    public void showOrderView() {
        List<Order> orders = iOrderService.getAllOrders();
        for (int i = 0; i < orders.size(); i++) {
            System.out.println("Mã hóa đơn: " + orders.get(i).getId());
            System.out.println("Fullname: " + orders.get(i).getFullName());
            System.out.println("Phone: " + orders.get(i).getPhone());
            System.out.println("Total: " + orders.get(i).getTotal());
            System.out.println("------------------------------");

            for (int j = 0; j < orders.get(i).getOrderItems().size(); j++) {
                OrderItem orderItem = orders.get(i).getOrderItems().get(j);

                Product p = iProductService.findProductById(orderItem.getIdProduct());
                System.out.printf("%10s %10s %5s %10s", p.getName(), orderItem.getPrice(), orderItem.getQuantity(),
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
            System.out.println("3. Đặt hàng: ");

            int actionMenu = Integer.parseInt(scanner.nextLine());
            switch (actionMenu) {
                case 1:
                    showOrderView();
                    break;
                case 3:
                    orderView();
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

    private void orderView() {
        System.out.println("Danh sách sản phẩm: ");
        List<Product> products = iProductService.getAllProducts();
        for (int i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            String fmtProduct = String.format("%5s | %10s | %10s | %10s | %10s",
                    p.getId(), p.getName(), p.getPrice(),
                    p.getDescription(), DateUtils.dateToString(p.getCreateAt()));

            System.out.println(fmtProduct);
        }


        boolean checkActionOrder = false;
        Order order = new Order();
        order.setId(System.currentTimeMillis()/1000);
        order.setCreateAt(new Date());
        do{
            System.out.println("Vui lòng chọn sản phẩm: ");
            // nhớ kiểm tra sản phẩm có tồn tại hay không
            long idProduct = Long.parseLong(scanner.nextLine());
            Product p = iProductService.findProductById(idProduct);
            System.out.println("Nhập số lượng: ");
            int quantity = Integer.parseInt(scanner.nextLine());

            if (order.getOrderItems() == null) {
                //(long id, long idOrder, long idProduct, int quantity, double price)
                OrderItem orderItem = new OrderItem(System.currentTimeMillis()/1000, order.getId(), idProduct,
                        quantity, p.getPrice());

                List<OrderItem> orderItems = new ArrayList<>();
                orderItems.add(orderItem);
                order.setOrderItems(orderItems);
            }else{
                if (checkProductExistsInOrder(idProduct, order) == false) {
                    OrderItem orderItem = new OrderItem(System.currentTimeMillis()/1000, order.getId(), idProduct,
                            quantity, p.getPrice());
                    order.getOrderItems().add(orderItem);
                }else{
                    updateProductInOrder(idProduct, quantity, p.getPrice(), order);
                }
            }
            order.updateTotal();
            System.out.println("Bạn có muốn chọn tiếp sản phẩm không: ");
            System.out.println("Yes (Y) / No (N)");
            String actionContinue = scanner.nextLine();
            switch (actionContinue) {
                case "Y":
                    checkActionOrder = true;
                    break;
                case "N":
                    checkActionOrder = false;
                    break;
            }
        }while (checkActionOrder);



        System.out.println("Nhập tên người mua: ");
        String fullName = scanner.nextLine();
        System.out.println("Nhập số điện thoại người mua: ");
        String phone = scanner.nextLine();
        order.setFullName(fullName);
        order.setPhone(phone);

        iOrderService.addOrder(order);
    }

    private void updateProductInOrder(long idProduct, int quantity, double price, Order order) {
        for (int i = 0; i < order.getOrderItems().size(); i++) {
            if (order.getOrderItems().get(i).getIdProduct() == idProduct) {
                order.getOrderItems().get(i).setQuantity(quantity);
                order.getOrderItems().get(i).setPrice(price);
            }
        }
    }

    private boolean checkProductExistsInOrder(long idProduct, Order order) {
        boolean check = false;
        if (order.getOrderItems() != null) {
            for (int i = 0; i < order.getOrderItems().size(); i++) {
                if (order.getOrderItems().get(i).getIdProduct() == idProduct) {
                    check = true;
                }
            }
        }
        return check;

    }


}
