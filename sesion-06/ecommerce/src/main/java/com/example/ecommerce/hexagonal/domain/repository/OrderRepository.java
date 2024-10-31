package com.example.ecommerce.hexagonal.domain.repository;

import com.example.ecommerce.hexagonal.domain.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {
    List<Order> findAll();
    Optional<Order> findById(Long id);
    Order save(Order order);
    void deleteById(Long id);
}
