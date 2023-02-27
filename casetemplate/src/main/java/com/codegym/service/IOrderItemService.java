package com.codegym.service;

import com.codegym.model.Order;
import com.codegym.model.OrderItem;

import java.util.List;

public interface IOrderItemService {

    List<OrderItem> getAllOrderItems();
    List<OrderItem> getAllOrderItemsByIdOrder(long idOrder);
    void addOrderItem(OrderItem orderItem);
}
