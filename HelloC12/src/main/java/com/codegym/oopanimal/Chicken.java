package com.codegym.oopanimal;

public class Chicken extends Animal{

    public Chicken(int _sochan, boolean _long) {
        this._long = _long;
        this._sochan = _sochan;
    }
    public Chicken() {

    }
    public void makeSound() {
        System.out.println("Chicken keu Ò ó o");
    }

    public void cachAn() {
        System.out.println("Ăn thịt gà thì luộc chấm muối tiêu thôi");
    }
}
