package com.imagina.orders_service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class GetOrderStatusUseCase {
    private final OrderRepository orderRepository;

    public Optional<Order> getOrderStatus(Long orderId) {
        // Buscar la orden por ID en el repositorio
        return orderRepository.findById(orderId);
    }
}
