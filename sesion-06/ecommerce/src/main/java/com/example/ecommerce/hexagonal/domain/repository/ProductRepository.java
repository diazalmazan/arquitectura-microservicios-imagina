package com.example.ecommerce.hexagonal.domain.repository;

import com.example.ecommerce.hexagonal.domain.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> findAll();
    Optional<Product> findById(Long id);
    Product save(Product order);
    void deleteById(Long id);
}
