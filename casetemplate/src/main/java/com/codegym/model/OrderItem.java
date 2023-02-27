package com.codegym.model;

import com.codegym.service.file.IModel;

public class OrderItem implements IModel<OrderItem> {
    private long id;
    private long idOrder;
    private long idProduct;
    private int quantity;
    private double price;

    public OrderItem(long id, long idOrder, long idProduct, int quantity, double price) {
        this.id = id;
        this.idOrder = idOrder;
        this.idProduct = idProduct;
        this.quantity = quantity;
        this.price = price;
    }

    public OrderItem() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(long idOrder) {
        this.idOrder = idOrder;
    }

    public long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(long idProduct) {
        this.idProduct = idProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }


    @Override
    public String toString() {
        //1677419670,1677419650,1,5,11000
        return String.format("%s,%s,%s,%s,%s", this.id, this.idOrder, this.idProduct, this.quantity, this.price);
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public OrderItem parseData(String line) {
        //1,1,1,5,11000
        // id,idOrder,idProduct,quantity,price
        String[] items = line.split(",");
        OrderItem orderItem = new OrderItem();
        orderItem.setId(Long.parseLong(items[0]));
        orderItem.setIdOrder(Long.parseLong(items[1]));
        orderItem.setIdProduct(Long.parseLong(items[2]));
        orderItem.setQuantity(Integer.parseInt(items[3]));
        orderItem.setPrice(Double.parseDouble(items[4]));

        return orderItem;
    }
}
