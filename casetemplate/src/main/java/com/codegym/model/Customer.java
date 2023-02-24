package com.codegym.model;

import com.codegym.service.file.IModel;
import com.codegym.utils.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Customer implements IModel<Customer> {
    private long id;
    private String name;
    private String phone;
    private String address;
    private Date createAt;


    private double consumed;
    private CustomerType customerType;


    public Customer(long id, String name, String phone, String address, Date createAt, double consumed, CustomerType customerType) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.createAt = createAt;
        this.consumed = consumed;
        this.customerType = customerType;
    }

    public Customer() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public double getConsumed() {
        return consumed;
    }

    public void setConsumed(double consumed) {
        this.consumed = consumed;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    @Override
    public String toString() {
        //1,Quang Dang,0399578134,28 NTP,20-12-2023 08:00,0,NORMAL
        return String.format("%s,%s,%s,%s,%s,%s,%s", this.id,this.name,this.phone,
        this.address, DateUtils.dateToString(this.createAt), this.consumed, this.customerType);
    }

    @Override
    public Customer parseData(String line) {
        String[] items = line.split(",");
        Customer customer = new Customer();
        customer.setId(Long.parseLong(items[0]));
        customer.setName(items[1]);
        customer.setPhone(items[2]);
        customer.setAddress(items[3]);
        customer.setCreateAt(DateUtils.parseDate(items[4]));
        customer.setConsumed(Double.parseDouble(items[5]));
        customer.setCustomerType(CustomerType.parseToCustomerType(items[6]));
        return customer;
    }
}
