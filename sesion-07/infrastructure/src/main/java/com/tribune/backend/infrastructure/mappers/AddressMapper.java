package com.tribune.backend.infrastructure.mappers;


import com.tribune.backend.domain.context.element.common.address.Address;
<<<<<<< HEAD
import com.tribune.backend.infrastructure.persistance.entities.AddressEntity;
=======
import com.tribune.backend.infrastructure.ports.out.persistance.entities.AddressEntity;
>>>>>>> 1ab50b7221baaf4ecf86b42016d4bea9c6aec187
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    @Mapping(source = "customer.id", target = "customer.id")
    @Mapping(source = "customer.displayName", target = "customer.name")
    @Mapping(source = "street", target = "street.name")
    @Mapping(source = "postalCode", target = "postalCode.value")
    @Mapping(source = "country", target = "country.code")
    Address toAddress(AddressEntity entity);

    @Mapping(source = "customer.id", target = "customer.id")
    @Mapping(source = "customer.name", target = "customer.displayName")
    @Mapping(source = "street.name", target = "street")
    @Mapping(source = "postalCode.value", target = "postalCode")
    @Mapping(source = "country.code", target = "country")
    AddressEntity toAddressEntity(Address address);
}
