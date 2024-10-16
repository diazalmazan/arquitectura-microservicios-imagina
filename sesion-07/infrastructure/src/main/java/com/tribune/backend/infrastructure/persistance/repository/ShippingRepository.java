package com.tribune.backend.infrastructure.persistance.repository;


import com.tribune.backend.infrastructure.persistance.entities.ShippingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShippingRepository extends JpaRepository<ShippingEntity, Long> {

}

