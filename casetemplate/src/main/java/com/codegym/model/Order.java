package com.codegym.model;

import java.util.Date;
import java.util.List;

public class Order {
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

}
