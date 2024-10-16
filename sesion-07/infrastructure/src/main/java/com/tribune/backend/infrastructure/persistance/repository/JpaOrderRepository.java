package com.tribune.backend.infrastructure.persistance.repository;


import com.tribune.backend.infrastructure.persistance.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaOrderRepository extends JpaRepository<OrderEntity, Long> {


}
