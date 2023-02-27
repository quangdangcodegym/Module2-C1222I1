package com.codegym.model;

import com.codegym.service.file.IModel;
import com.codegym.utils.DateUtils;

import java.util.Date;
import java.util.List;

public class Order implements IModel<Order> {
    private long id;
    private String fullName;
    private String phone;
    private Date createAt;
    private double total;

    private List<OrderItem> orderItems;


    public Order(long id, String fullName, String phone, Date createAt, double total, List<OrderItem> orderItems) {
        this.id = id;
        this.fullName = fullName;
        this.phone = phone;
        this.createAt = createAt;
        this.total = total;
        this.orderItems = orderItems;
    }
    public Order(long id, String fullName, String phone, Date createAt, double total) {
        this.id = id;
        this.fullName = fullName;
        this.phone = phone;
        this.createAt = createAt;
        this.total = total;
    }

    public Order() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public void updateTotal() {
        double total = 0;
        if (this.getOrderItems() != null) {
            for (int i = 0; i < this.getOrderItems().size(); i++) {
                total += this.getOrderItems().get(i).getQuantity() * this.getOrderItems().get(i).getPrice();
            }
        }
        this.setTotal(total);
    }

    @Override
    public String toString() {
//        id,fullname,phone,createat,total
//        1,Dang Quang,0399578134,20-12-2023 08:00,100000
        return String.format("%s,%s,%s,%s,%s", this.id, this.fullName, this.phone,
                DateUtils.dateToString(this.createAt), this.total);
    }

    @Override
    public Order parseData(String line) {
        //1,Dang Quang,0399578134,20-12-2023 08:00,105000
        String[] items = line.split(",");
        Order order = new Order();
        order.setId(Long.parseLong(items[0]));
        order.setFullName(items[1]);
        order.setPhone(items[2]);
        order.setCreateAt(DateUtils.parseDate(items[3]));
        order.setTotal(Double.parseDouble(items[4]));

        return order;
    }
}
