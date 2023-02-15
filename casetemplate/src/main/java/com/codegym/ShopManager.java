package com.codegym;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ShopManager {
    private Scanner scanner = new Scanner(System.in);
    private List<Product> products;

    public ShopManager() {
        products = new ArrayList<>();
        products.add(new Product(1L, "Iphone 11", "2 mat", 2000, new Date()));
        products.add(new Product(2L, "Iphone 12", "2 mat", 2000, new Date()));
        products.add(new Product(3L, "Iphone 13", "2 mat", 2000, new Date()));
        products.add(new Product(4L, "Iphone 14", "2 mat", 2000, new Date()));
        products.add(new Product(5L, "Iphone 15", "2 mat", 2000, new Date()));
    }
    public void showProductsView() {
        for (int i = 0; i < products.size(); i++) {
            System.out.println(products.get(i));
        }
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void deleteProductById(long idProduct) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == idProduct) {
                products.remove(i);
                break;
            }
        }
    }

    public void deleteProductView() {
        System.out.println("Nhập id cần xóa: ");
        long idProduct = Long.parseLong(scanner.nextLine());
        deleteProductById(idProduct);
        showProductsView();
    }
}
