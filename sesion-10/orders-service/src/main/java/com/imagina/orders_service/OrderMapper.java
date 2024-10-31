package com.imagina.orders_service;

import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    public OrderEntity toEntity(Order order) {
        return new OrderEntity(
                order.getOrderId(),
                order.getProductId(),
                order.getQuantity(),
                order.getStatus()
        );
    }

    public Order toDomain(OrderEntity entity) {
        return new Order(
                entity.getOrderId(),
                entity.getProductId(),
                entity.getQuantity(),
                entity.getStatus()
        );
    }
}
