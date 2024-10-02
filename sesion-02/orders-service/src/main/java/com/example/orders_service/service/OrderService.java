package com.example.orders_service.service;

import com.example.orders_service.model.Order;
import reactor.core.publisher.Mono;

import java.util.List;

public interface OrderService {
    List<Order> getOrders();

    Order getOrder(Long id);

    Mono<Order> addOrder(Order order);

    void deleteOrder(Long id);
}
