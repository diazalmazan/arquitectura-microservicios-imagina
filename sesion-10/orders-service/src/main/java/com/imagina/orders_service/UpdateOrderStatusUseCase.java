package com.imagina.orders_service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateOrderStatusUseCase {
    private final OrderRepository orderRepository;

    public void updateOrderStatus(Long orderId, String status) {
        // Buscar la orden y actualizar su estado
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Orden no encontrada."));
        order.setStatus(status);
        orderRepository.save(order);
    }
}
