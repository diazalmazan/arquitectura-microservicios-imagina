package com.imagina.orders_service.infrastructure.adapter.jpa;

import com.imagina.orders_service.infrastructure.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderJpaRepository extends JpaRepository<OrderEntity, Long> {
}
