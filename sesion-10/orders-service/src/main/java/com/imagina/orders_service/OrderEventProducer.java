package com.imagina.orders_service;

public interface OrderEventProducer {
    void publishOrderCreatedEvent(Order order);
}
