package com.techelevator.dao;

import com.techelevator.model.Product;

import java.util.List;

public interface ProductDao {
    List<Product> getProducts();
    List<Product> searchProductBySkuAndName(String sku, String name);
    List<Product> searchProductBySku(String sku);
    List<Product> searchProductByName(String name);
    Product getProductById(int id);
}
