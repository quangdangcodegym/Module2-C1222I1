package com.codegym.lamda.demo;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class DemoLamda {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 5, 7);

//        Function;
        Function func = new FuncImpl();
        List<String> list = numbers.stream().map(func).toList();


        List<String> list1 = numbers.stream().map((a)-> a*2 + " +").toList();

        System.out.println(list);
        System.out.println(list1);


        List<String> list2 = numbers.stream().map(Hello::codegym).toList();
        System.out.println(list2);

    }
}
