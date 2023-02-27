package com.codegym.service.file;

import com.codegym.model.Order;
import com.codegym.model.OrderItem;
import com.codegym.service.IOrderItemService;
import com.codegym.service.IOrderService;
import com.codegym.utils.FileUtils;

import java.util.List;

public class FOrderService implements IOrderService {
    private IOrderItemService iOrderItemService;

    public FOrderService() {
        iOrderItemService = new FOrderItemService();
    }
    @Override
    public List<Order> getAllOrders() {
        List<Order> orders = FileUtils.readDataFromFile("./data/order.csv", Order.class);

        for (int i = 0; i < orders.size(); i++) {
            List<OrderItem> orderItems = iOrderItemService.getAllOrderItemsByIdOrder(orders.get(i).getId());
            orders.get(i).setOrderItems(orderItems);
        }
        return orders;
    }

    @Override
    public void addOrder(Order order) {
        List<Order> orders = getAllOrders();
        orders.add(order);

        if (order.getOrderItems() != null) {
            for (int i = 0; i < order.getOrderItems().size(); i++) {
                iOrderItemService.addOrderItem(order.getOrderItems().get(i));
            }
        }
        FileUtils.writeDataToFile("./data/order.csv", orders);
    }
}
