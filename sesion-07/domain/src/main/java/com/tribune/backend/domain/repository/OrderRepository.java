package com.tribune.backend.domain.repository;

import com.tribune.backend.domain.context.element.order.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {
    Order save(Order order);
    Order saveAndFlush(Order order);
    Optional<Order> findById(Long id);
    List<Order> findAll();
}
