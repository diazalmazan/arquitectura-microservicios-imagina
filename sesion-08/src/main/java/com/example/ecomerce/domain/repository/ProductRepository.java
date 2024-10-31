package com.example.ecomerce.domain.repository;

import com.example.ecomerce.domain.context.product.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> getAll();

    void saveAll(List<Product> products);

    Product save(Product product);

    Product getById(Long id);

}
