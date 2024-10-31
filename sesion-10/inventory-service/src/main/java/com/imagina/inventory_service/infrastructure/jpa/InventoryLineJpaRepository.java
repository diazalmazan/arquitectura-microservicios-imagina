package com.imagina.inventory_service.infrastructure.jpa;

import com.imagina.inventory_service.infrastructure.model.entities.InventoryLineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryLineJpaRepository extends JpaRepository<InventoryLineEntity, Long> {
    InventoryLineEntity findByProductId(Long productId);
}
