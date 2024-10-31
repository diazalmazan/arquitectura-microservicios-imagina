package com.tribune.backend.infrastructure.mappers;

import com.tribune.backend.infrastructure.ports.in.model.dto.SubmitOrderRequest;
import com.tribune.backend.model.CreateOrderCommand;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CreateOrderMapper {

    @Mapping(source = "submitOrderRequest.id", target = "createOrderCommand.id")
    @Mapping(source = "submitOrderRequest.displayName", target = "customer.name")
    @Mapping(source = "submitOrderRequest", target = "street.name")
    CreateOrderCommand toCreateOrderCommand(SubmitOrderRequest submitOrderRequest);

}
