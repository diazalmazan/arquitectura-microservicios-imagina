package com.tribune.backend.infrastructure.adapters;

import com.tribune.backend.domain.context.element.customer.Customer;
import com.tribune.backend.domain.repository.CustomerRepository;
import com.tribune.backend.infrastructure.mappers.CustomerMapper;
import com.tribune.backend.infrastructure.ports.out.persistance.repository.JpaCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    @Autowired
    private JpaCustomerRepository jpaCustomerRepository;
    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public Optional<Customer> findById(Long id) {
        return Optional.of(customerMapper.toCustomer(jpaCustomerRepository.findById(id).get()));
    }
}
