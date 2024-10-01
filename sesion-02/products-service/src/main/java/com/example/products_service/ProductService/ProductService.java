package com.example.products_service.ProductService;

import com.example.products_service.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();
    Product getProduct(Long id);
    Product addProduct(Product product);
}
