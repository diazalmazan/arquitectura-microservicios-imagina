package com.imagina.inventory_service.infrastructure.jpa;

import com.imagina.inventory_service.infrastructure.model.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductJpaRepository extends JpaRepository<ProductEntity, Long> {
}

