package com.tribune.backend.infrastructure.mappers;


import com.tribune.backend.domain.context.element.customer.Customer;
<<<<<<< HEAD
import com.tribune.backend.infrastructure.persistance.entities.CustomerEntity;
=======
import com.tribune.backend.infrastructure.ports.out.persistance.entities.CustomerEntity;
>>>>>>> 1ab50b7221baaf4ecf86b42016d4bea9c6aec187
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    Customer toCustomer(CustomerEntity entity);
    CustomerEntity toCustomerEntity(Customer customer);

}
