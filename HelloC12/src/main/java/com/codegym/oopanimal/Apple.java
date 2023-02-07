package com.codegym.oopanimal;

public class Apple extends Fruit implements CachAn{

    @Override
    public void cachAn() {
        System.out.println("Ăn táo thì cắn luôn nghe");
    }
}
