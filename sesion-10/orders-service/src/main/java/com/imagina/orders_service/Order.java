package com.imagina.orders_service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private Long orderId;
    private Long productId;
    private int quantity;
    private String status; // PENDING, COMPLETED, CANCELLED

    public void markAsPending() {
        this.status = "PENDING";
    }

    public void markAsCompleted() {
        this.status = "COMPLETED";
    }

    public void markAsCancelled() {
        this.status = "CANCELLED";
    }
}
