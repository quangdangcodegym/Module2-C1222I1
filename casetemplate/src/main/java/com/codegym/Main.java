package com.codegym;

import com.codegym.view.CustomerView;
import com.codegym.view.OrderView;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        /**
        ProductView productView = new ProductView();
        productView.laucher();

         OrderView orderView = new OrderView();
         orderView.launcher();

         **/

        CustomerView customerView = new CustomerView();
        customerView.launcher();


    }
}
