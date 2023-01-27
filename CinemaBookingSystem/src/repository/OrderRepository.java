package repository;

import model.Order;
import model.Ticket;

public class OrderRepository extends  FileContext<Order>{
    public OrderRepository() {
        filePath = "./data/order.csv";
        tClass = Order.class;
    }
}
