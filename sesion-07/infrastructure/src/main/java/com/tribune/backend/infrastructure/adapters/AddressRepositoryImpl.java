package com.tribune.backend.infrastructure.adapters;

import com.tribune.backend.domain.context.element.common.address.Address;
import com.tribune.backend.domain.repository.AddressRepository;
import com.tribune.backend.infrastructure.mappers.AddressMapper;
import com.tribune.backend.infrastructure.ports.out.persistance.repository.JpaAddressRepository;
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
