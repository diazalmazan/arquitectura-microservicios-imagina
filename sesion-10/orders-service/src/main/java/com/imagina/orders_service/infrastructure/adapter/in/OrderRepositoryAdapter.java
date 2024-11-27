package com.imagina.orders_service.infrastructure.adapter.in;

import com.imagina.orders_service.infrastructure.adapter.jpa.OrderJpaRepository;
import com.imagina.orders_service.infrastructure.adapter.OrderMapper;
import com.imagina.orders_service.domain.model.Order;
import com.imagina.orders_service.application.port.out.OrderRepository;
import com.imagina.orders_service.infrastructure.model.OrderEntity;
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
