package com.codegym.oopcomparator.animal;

public class Chicken extends Animal {

    public Chicken(int _sochan, boolean _long, float _cannang) {
        this._long = _long;
        this._sochan = _sochan;
        this._cannang = _cannang;
    }
    public Chicken() {

    }
    public void makeSound() {
        System.out.println("Chicken keu Ò ó o");
    }

    public void cachAn() {
        System.out.println("Ăn thịt gà thì luộc chấm muối tiêu thôi");
    }

    @Override
    public float layCanNang() {
        if (this._long == true) {
            return this._cannang + 0.2f;
        } else {
            return this._cannang;
        }
    }
}
