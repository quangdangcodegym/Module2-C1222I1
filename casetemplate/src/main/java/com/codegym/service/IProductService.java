package com.codegym.service;

import com.codegym.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAllProducts();
    void addProduct(Product product);
    void deleteProductById(long idProduct);

    void updateProductById(long idProduct, Product product);
}
