package com.codegym.oopextends;

public class Rectangle extends Geometric{
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
}
