package com.tribune.backend.infrastructure.persistance.repository;


import com.tribune.backend.infrastructure.persistance.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCustomerRepository extends JpaRepository<CustomerEntity, Long> {

}

