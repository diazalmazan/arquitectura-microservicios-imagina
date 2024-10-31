package com.tribune.backend.infrastructure.ports.in.model.dto;


import com.tribune.backend.domain.context.element.common.address.Address;
import com.tribune.backend.domain.context.element.shipping.ShippingStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ShippingStatusResponse {

    private Long order;

    private Address address;

    private ShippingStatus status;

}
