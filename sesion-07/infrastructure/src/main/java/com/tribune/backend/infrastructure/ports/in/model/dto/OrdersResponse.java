package com.tribune.backend.infrastructure.ports.in.model.dto;


import lombok.*;

import java.util.List;

@Data
@Builder
public class OrdersResponse {
    private List<SingleOrderResponse> blogs;
}
