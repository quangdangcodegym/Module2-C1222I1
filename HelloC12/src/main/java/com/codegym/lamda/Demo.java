package com.codegym.lamda;

public class Demo {
    public int action(int a, int b, MyFunction func) {
        return func.accept(a, b);
    }
    public static void main(String[] args) {
        Demo demo = new Demo();


        int kq = demo.action(12, 6, new MyFunction() {
            @Override
            public int accept(int a, int b) {
                return a/b;
            }
        });
        System.out.println(kq);


    }
}
