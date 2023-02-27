package com.codegym.service.file;

import com.codegym.model.OrderItem;
import com.codegym.service.IOrderItemService;
import com.codegym.utils.FileUtils;

import java.util.ArrayList;
import java.util.List;

public class FOrderItemService implements IOrderItemService {
    @Override
    public List<OrderItem> getAllOrderItems() {
        return FileUtils.readDataFromFile("./data/orderitem.csv", OrderItem.class);
    }

    @Override
    public List<OrderItem> getAllOrderItemsByIdOrder(long idOrder) {
        List<OrderItem> orderItemDatas = FileUtils.readDataFromFile("./data/orderitem.csv", OrderItem.class);


        List<OrderItem> orderItems = new ArrayList<>();
        for (int i = 0; i < orderItemDatas.size(); i++) {
            if (orderItemDatas.get(i).getIdOrder() == idOrder) {
                orderItems.add(orderItemDatas.get(i));
            }
        }
        return orderItems;
    }

    @Override
    public void addOrderItem(OrderItem orderItem) {
        List<OrderItem> orderItems = getAllOrderItems();

        orderItems.add(orderItem);
        FileUtils.writeDataToFile("./data/orderitem.csv", orderItems);
    }
}
