package com.imagina.orders_service;

import java.util.Optional;

public interface OrderRepository {
    void save(Order order);
    Optional<Order> findById(Long orderId);
}
