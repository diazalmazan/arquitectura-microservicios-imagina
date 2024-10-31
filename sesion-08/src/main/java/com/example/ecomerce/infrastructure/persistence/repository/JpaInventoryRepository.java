package com.example.ecomerce.infrastructure.persistence.repository;


import com.example.ecomerce.infrastructure.persistence.entity.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JpaInventoryRepository extends JpaRepository<InventoryEntity, Long> {

    InventoryEntity findByProductId(Long productId);
}
