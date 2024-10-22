package com.imagina.inventory_service.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryResponseEventDto {
    private Long orderId;
    private String status; // COMPLETED or CANCELLED
}
