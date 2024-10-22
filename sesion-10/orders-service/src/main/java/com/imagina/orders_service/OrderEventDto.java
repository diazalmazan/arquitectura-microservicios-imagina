package com.imagina.orders_service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderEventDto {
    private Long orderId;
    private Long productId;
    private int quantity;
    private String status; // PENDING, COMPLETED, CANCELLED
}
