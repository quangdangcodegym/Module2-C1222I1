package com.codegym.lamda.demo;

import java.util.function.Function;

public class FuncImpl implements Function<Integer, String> {
    @Override
    public String apply(Integer integer) {
        return integer*2 + " *";
    }
}
