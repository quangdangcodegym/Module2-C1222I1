package com.codegym.service;

import com.codegym.model.Order;

import java.util.List;

public interface IOrderService {
    List<Order> getAllOrders();

    void addOrder(Order order);
}
