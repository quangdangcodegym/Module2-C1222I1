package com.codegym.oop;

public class Fan {
    /**
     Từ khóa static
     */
    public static int LOW = 1;
    public static  int MEDIUM = 2;
    public static int FAST = 3;



    // access modifier của thuộc tính: private, public, protected, default
    // biến instanse: phạm vị toàn cục, biến của đối tuong, sẽ có giá trị mặc định: int = 0,  boolean = false, String null
    //

    private int id;
    private int speed;
    private boolean on;
    private float radius;
    private double price;

    private String color;

    String manufacturer;


    public void setSpeed(int speed) {

        this.speed = speed;
    }
    public int getSpeed() {
        return speed;
    }

    public void setOn(boolean on){
        // biến local hay biến cục bộ:
//        int a = 0;
//        System.out.println("a: " + a);

        this.on = on;
    }

    public boolean getOn() {
        return this.on;
    }

    public String getColor() {
//        System.out.println("Giá tri bien a: " + speed);
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // access modifier của phương thức: private, public, protected, default
    public String showFan() {
        String onOff = "";
        if (this.on == false) {
            onOff = "OFF";
        } else {
            onOff = "ON";
        }
        return "Fan: " + this.id + " speed: " + this.speed + " color: " + this.color + ": " + onOff;
    }

    public Fan(int speed, float radius, String color) {
        this.speed = speed;
        this.radius = radius;
        this.color = color;
    }
    public Fan(int id, int speed, float radius, String color) {
        this.id = id;
        this.speed = speed;
        this.radius = radius;
        this.color = color;
    }
    public Fan(int id, int speed, float radius, String color, double price) {
        this.id = id;
        this.speed = speed;
        this.radius = radius;
        this.color = color;
        this.price = price;
    }
    public Fan() {

    }


    public static void main(String[] args) {
        Fan fan1 = new Fan();
        Fan fan2 = new Fan(LOW, 5.0f, "RED");

        System.out.println(Fan.LOW);
    }
}
