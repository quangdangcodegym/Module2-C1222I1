package com.codegym.lamda;

public class AddFunc implements MyFunction{
    @Override
    public int accept(int a, int b) {
        return (a+b)*2;
    }
}
