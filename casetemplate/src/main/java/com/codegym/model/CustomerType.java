package com.codegym.model;

public enum CustomerType {
    NORMAL(0L, "Normal"),
    SILVER(1L, "Khách hạng Bạc"),
    BRONZE(2L, "Khách hạng Đồng"),
    GOLD(3L, "Khách hạng Vàng");
    private long id;
    private String name;
    private CustomerType(long id,String name) {
        this.id = id;
        this.name = name;
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

    public static CustomerType parseToCustomerType(String str) {
        // str: NORMAL
        for (CustomerType item : CustomerType.values()){
            if (item.toString().equals(str)) {
                return item;
            }
        }
        return null;
    }
    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        for (CustomerType item : CustomerType.values()) {
            System.out.println(item.getId() + " - "  + item.getName());
        }
    }
}
