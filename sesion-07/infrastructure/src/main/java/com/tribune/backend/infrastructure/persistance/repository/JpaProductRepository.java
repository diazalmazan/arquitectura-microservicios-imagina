package com.tribune.backend.infrastructure.persistance.repository;


import com.tribune.backend.infrastructure.persistance.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaProductRepository extends JpaRepository<ProductEntity, Long> {

    List<ProductEntity> getAllByIdIn(List<Long> ids);
}
