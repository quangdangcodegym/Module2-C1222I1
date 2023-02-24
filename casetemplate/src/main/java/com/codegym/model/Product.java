package com.codegym.model;

import com.codegym.service.file.IModel;
import com.codegym.utils.DateUtils;

import java.util.Date;
import java.util.Objects;

public class Product implements IModel<Product> {
    private long id;
    private String name;
    private String description;
    private double price;
    private Date createAt;


    public Product(long id, String name, String description, double price, Date createAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.createAt = createAt;
    }

    public Product() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    @Override
    public String toString() {
//        return "Product " + this.name + " price: " + this.price;
        //4,Iphone14,I phone 14 dep quá, 11000,20-12-2023 08:00
        return String.format("%s,%s,%s,%s,%s", this.getId(), this.getName(), this.getDescription()
                , this.getPrice(), DateUtils.dateToString(this.createAt));
    }


    @Override
    public boolean equals(Object obj) {
        Product p = (Product) obj;
        if (this == p) {
            return true;
        }
        if (this.getName().equals(p.getName())) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name);
    }

    @Override
    public Product parseData(String line) {
        String[] items = line.split(",");
        Product product = new Product();
        product.setId(Long.parseLong(items[0]));
        product.setName(items[1]);
        product.setDescription(items[2]);
        product.setPrice(Double.parseDouble(items[3]));
        product.setCreateAt(DateUtils.parseDate(items[4]));

        return product;
    }


}
