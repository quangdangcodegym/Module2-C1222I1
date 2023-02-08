package com.codegym.oopcomparator;


public class Circle extends Geometric {

    private float radius;

    public Circle() {

    }

    @Override
    public double getArea() {
        return Math.PI * this.radius * this.radius;
    }

    @Override
    public double getPrimeter() {
        return this.radius*Math.PI*2;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        if (radius < 0) {
            this.radius = 0;
        }
        this.radius = radius;
    }

    public Circle(String color, boolean filled) {
        // từ khóa supper đẻ gọi đến contructor của lớp cha
        super(color, filled);
        /**
         this.color = color;
         this.filled = filled;
         **/
    }

    public Circle(float radius, String color, boolean filled) {
        this.radius = radius;
        this.color = color;
        this.filled = filled;
    }

    @Override
    public String getColor() {
        return "Circle color: " + this.color;
    }

    @Override
    public String toString() {
        return "Circle: " + " color: " + this.color + " filled: " + this.filled;
    }


}
