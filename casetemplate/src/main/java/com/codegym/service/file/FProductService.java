package com.codegym.service.file;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import com.codegym.utils.DateUtils;
import com.codegym.utils.FileUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FProductService implements IProductService {
    private final String  pathProduct = "./data/product.csv";
    @Override
    public List<Product> getAllProducts() {
        return FileUtils.readDataFromFile(pathProduct, Product.class);
    }

    @Override
    public void addProduct(Product product) {
        List<Product> products = getAllProducts();
        long lastId = 1;
        if(products.size()!=0){
            Product lastCustomer = products.get(products.size()-1);
            lastId = lastCustomer.getId()+1;
        }
        product.setId(lastId);

        products.add(product);

        FileUtils.writeDataToFile(pathProduct, products);
    }

    @Override
    public void deleteProductById(long idProduct) {
        List<Product> products = getAllProducts();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == idProduct) {
                products.remove(i);
            }
        }
        FileUtils.writeDataToFile(pathProduct, products);
    }

    @Override
    public void updateProductById(long idProduct, Product product) {
        List<Product> products = getAllProducts();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == idProduct) {
                products.get(i).setName(product.getName());
                products.get(i).setDescription(product.getDescription());
                products.get(i).setPrice(product.getPrice());
                products.get(i).setCreateAt(product.getCreateAt());
            }
        }
        FileUtils.writeDataToFile(pathProduct, products);
    }

    @Override
    public Product findProductById(long idProduct) {
        List<Product> products = getAllProducts();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == idProduct) {
                return products.get(i);
            }
        }
        return null;
    }
}
