package com.codegym.service.inmemory;

import com.codegym.model.Order;
import com.codegym.model.OrderItem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IMOrderService {
    private List<Order> orders;


    public IMOrderService() {
        orders = new ArrayList<>();
        //Order(long id, String fullName, String phone, Date createAt, double total)
        Order o1 = new Order(1L, "Quang Dang", "0399", new Date(), 0);

        //OrderItem(long id, long idOrder, long idProduct, int quantity, double price)
        OrderItem orderItem1 = new OrderItem(1L, 1L, 1L, 5, 11000);
        OrderItem orderItem2 = new OrderItem(2L, 1L, 2L, 10, 12000);
        List<OrderItem> orderItems1 = new ArrayList<>();
        orderItems1.add(orderItem1);
        orderItems1.add(orderItem2);

        o1.setOrderItems(orderItems1);


        Order o2 = new Order(2L, "Sinh Nhat", "0555", new Date(), 0);

        OrderItem orderItem3 = new OrderItem(3L, 2L, 2L, 50, 12000);
        List<OrderItem> orderItems2 = new ArrayList<>();
        orderItems2.add(orderItem3);

        o2.setOrderItems(orderItems2);

        orders.add(o1);
        orders.add(o2);
    }

    public List<Order> getAllOrders() {
        return this.orders;
    }

}
