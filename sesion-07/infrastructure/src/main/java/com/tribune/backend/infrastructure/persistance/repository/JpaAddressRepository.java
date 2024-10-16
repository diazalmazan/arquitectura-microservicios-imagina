package com.tribune.backend.infrastructure.persistance.repository;


import com.tribune.backend.infrastructure.persistance.entities.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaAddressRepository extends JpaRepository<AddressEntity, Long> {

}

