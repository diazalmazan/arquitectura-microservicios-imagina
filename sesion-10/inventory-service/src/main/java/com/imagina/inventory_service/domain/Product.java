package com.imagina.inventory_service.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Long id;
    private String name;
    private double price;
    private String description;

    public void validatePrice() {
        if (this.price <= 0) {
            throw new IllegalArgumentException("El precio del producto debe ser mayor a cero.");
        }
    }
}
