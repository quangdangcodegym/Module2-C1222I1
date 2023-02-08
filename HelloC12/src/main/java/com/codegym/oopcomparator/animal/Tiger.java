package com.codegym.oopcomparator.animal;

public class Tiger extends Animal {

    public Tiger(int _sochan, boolean _long) {
        this._long = _long;
        this._sochan = _sochan;
    }
    public Tiger() {

    }
    @Override
    public void makeSound() {
        System.out.println("Tiger keu woaaaaaaa");
    }

    @Override
    public float layCanNang() {
        return 100.0f;
    }

    public void cachAn() {
        System.out.println("Ăn thịt cọp thì HON chơ dai lắm");
    }
}
