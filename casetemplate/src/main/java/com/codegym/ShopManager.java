package com.codegym;

import java.util.*;

public class ShopManager {
    private Scanner scanner = new Scanner(System.in);
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public ShopManager() {
        products = new ArrayList<>();
        products.add(new Product(1L, "Iphone 11", "2 mat", 7000, new Date()));
        products.add(new Product(2L, "Iphone 122", "2 mat", 2000, new Date()));
        products.add(new Product(3L, "Iphone 1322", "2 mat", 8000, new Date()));
        products.add(new Product(4L, "Iphone 14", "2 mat", 1000, new Date()));
        products.add(new Product(5L, "Iphone 1522", "2 mat", 4000, new Date()));
    }
    public void showProductsView(List<Product> products) {
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
        showProductsView(products);
    }

    public void sortProductByPriceView() {
        System.out.println("Sắp xếp sản phẩm theo giá");
        Comparator comparator = new ComparatorByPrice();
        products.sort(comparator);
        showProductsView(products);
    }

    public void searchProductView() {
        System.out.println("Tìm kiếm theo tên: ");
        String nameSearch = scanner.nextLine();
        List<Product> results = new ArrayList<>();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getName().contains(nameSearch)) {
                results.add(products.get(i));
            }
        }
        showProductsView(results);
    }
}
