package com.codegym.oopextends;

public class Circle extends Geometric {

    private float radius;

    public Circle() {

    }

    public float getArea() {
        return ((float) Math.PI) * this.radius * this.radius;
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

//    @Override
//    public String toString() {
//        return "Circle: " + " color: " + this.color + " filled: " + this.filled;
//
//
////         "Circle: Geometric color: RED filled: true
////        return "Circle: " + super.toString();
////
////
////        System.out.println("tau gọi lại mi nè...");
////        try {
////            Thread.sleep(2000);
////        } catch (InterruptedException e) {
////            throw new RuntimeException(e);
////        }
////        return "Circle: " + this.toString();
//
//
//    }

}
