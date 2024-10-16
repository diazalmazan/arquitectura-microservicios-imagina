package com.tribune.backend.infrastructure.persistance.repository;

import com.tribune.backend.domain.context.element.common.address.Address;
import com.tribune.backend.domain.repository.AddressRepository;
import com.tribune.backend.infrastructure.mappers.AddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class AddressRepositoryImpl implements AddressRepository {

    @Autowired
    private JpaAddressRepository jpaAddressRepository;
    @Autowired
    private AddressMapper addressMapper;
    @Override
    public Optional<Address> findById(Long id) {
        return Optional.of(addressMapper.toAddress(jpaAddressRepository.findById(id).get()));
    }
}
