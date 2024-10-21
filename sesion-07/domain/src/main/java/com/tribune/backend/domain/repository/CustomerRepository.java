package com.tribune.backend.domain.repository;

import com.tribune.backend.domain.context.element.customer.Customer;

import java.util.Optional;

public interface CustomerRepository {
    Optional<Customer> findById(Long id);
}
