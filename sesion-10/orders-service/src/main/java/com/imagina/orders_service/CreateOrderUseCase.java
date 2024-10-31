package com.imagina.orders_service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateOrderUseCase {
    private final OrderRepository orderRepository;
    private final OrderEventProducer orderEventProducer;

    public Order createOrder(Long productId, int quantity) {
        // Crear nueva orden
        Order order = new Order();
        order.setProductId(productId);
        order.setQuantity(quantity);
        order.markAsPending();

        // Guardar la orden en estado PENDING
        orderRepository.save(order);

        // Publicar evento de creación de orden
        orderEventProducer.publishOrderCreatedEvent(order);

        return order;
    }
}
