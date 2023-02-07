package com.codegym.ooppoint;

public class PointApp {
    public static void main(String[] args) {
        Object p1 = new Point2D(4.0f, 2.0f);


        Point2D p2 = new Point3D(5.0f, 2.0f, 15.0f);
        //
        System.out.println(p1.toString());


        System.out.println(p2.getX());
//        System.out.println(p2.getZ());

        Point3D p3 = (Point3D) p2;
        System.out.println(p3.getZ());

    }
}
