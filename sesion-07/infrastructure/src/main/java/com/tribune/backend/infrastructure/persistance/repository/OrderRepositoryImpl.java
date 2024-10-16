package com.tribune.backend.infrastructure.persistance.repository;

import com.tribune.backend.domain.context.element.order.Order;
import com.tribune.backend.domain.repository.OrderRepository;
import com.tribune.backend.infrastructure.mappers.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

    @Autowired
    private JpaOrderRepository jpaOrderRepository;
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Order save(Order order) {
        var savedOrder = jpaOrderRepository.save(orderMapper.toOrderEntity(order));
        return orderMapper.toOrder(savedOrder);
    }

    @Override
    public Order saveAndFlush(Order order) {
        var savedOrder = jpaOrderRepository.saveAndFlush(orderMapper.toOrderEntity(order));
        return orderMapper.toOrder(savedOrder);
    }

    @Override
    public Optional<Order> findById(Long id) {
        return Optional.of(orderMapper
                .toOrder(jpaOrderRepository
                        .findById(id)
                        .get()));
    }

    @Override
    public List<Order> findAll() {
        return jpaOrderRepository
                .findAll()
                .stream()
                .map(orderEntity -> orderMapper.toOrder(orderEntity))
                .collect(Collectors.toList());
    }
}
