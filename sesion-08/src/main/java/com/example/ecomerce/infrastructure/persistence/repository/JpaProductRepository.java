package com.example.ecomerce.infrastructure.persistence.repository;

import com.example.ecomerce.infrastructure.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaProductRepository extends JpaRepository<ProductEntity, Long> {

    //List<ProductEntity> getAllByIdIn(List<Long> ids);

    //List<ProductEntity> getAll();
}