package com.imagina.orders_service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class OrderRepositoryAdapter implements OrderRepository {
    private final OrderJpaRepository orderJpaRepository;
    private final OrderMapper orderMapper;

    @Override
    public void save(Order order) {
        OrderEntity orderEntity = orderMapper.toEntity(order);
        orderJpaRepository.save(orderEntity);
    }

    @Override
    public Optional<Order> findById(Long orderId) {
        return orderJpaRepository.findById(orderId)
                .map(orderMapper::toDomain);
    }
}
