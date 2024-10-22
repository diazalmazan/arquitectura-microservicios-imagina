package com.imagina.inventory_service.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryLine {
    private Long inventoryId;
    private Long productId;  // Asociado al Producto
    private int stock;

    public void validateStock() {
        if (this.stock < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo.");
        }
    }

    public void updateStock(int newStock) {
        if (newStock < 0) {
            throw new IllegalArgumentException("No se puede actualizar el stock a un valor negativo.");
        }
        this.stock = newStock;
    }
}

