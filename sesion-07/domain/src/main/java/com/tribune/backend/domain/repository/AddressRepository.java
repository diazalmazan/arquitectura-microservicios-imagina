package com.tribune.backend.domain.repository;

import com.tribune.backend.domain.context.element.common.address.Address;

import java.util.Optional;

public interface AddressRepository {
    Optional<Address> findById(Long id);
}
