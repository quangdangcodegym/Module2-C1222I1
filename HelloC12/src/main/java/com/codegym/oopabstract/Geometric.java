package com.codegym.oopabstract;

import java.util.Date;

public abstract class Geometric {
    // private,default, protected, public
    protected String color ;
    protected boolean filled;
    private Date dateCreated;

    public Geometric() {

    }

    public Geometric(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }


    public String getColor() {
        return "Geometric: color " + color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
    // hàm toString trả về thông tin của đối tượng
    public String toString() {
        return "Geometric: " + this.color + ", filled: " +this.filled;
    }

    public abstract void getArea();
}
