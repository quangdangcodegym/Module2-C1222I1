package com.codegym.oopcomparator;


public class Rectangle extends Geometric {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public Rectangle(double width, double height, String color, boolean filled) {
        this.width = width;
        this.height = height;
        this.color = color;
        this.filled = filled;
    }
    public Rectangle() {

    }

    @Override
    public String getColor() {
        return "Rectangle color: " + this.color;
    }

    @Override
    public double getArea() {
        return this.height*this.width;
    }

    @Override
    public double getPrimeter() {
        return (this.height+this.width)*2;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                "} area: " + this.getArea() + " primeter: " + this.getPrimeter();
    }
}
