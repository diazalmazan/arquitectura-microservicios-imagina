package com.imagina.inventory_service.domain;

import lombok.Data;

@Data
public class Inventory {
    private Product product;
    private InventoryLine inventoryLine;

    public Inventory(Product product, InventoryLine inventoryLine) {
        this.product = product;
        this.inventoryLine = inventoryLine;

        // Validación inicial
        validate();
    }

    // Método para actualizar el stock
    public void updateStock(int newStock) {
        inventoryLine.updateStock(newStock);
    }

    // Validación de reglas de negocio al crear o modificar el inventario
    private void validate() {
        product.validatePrice();  // El precio del producto debe ser mayor a cero
        inventoryLine.validateStock();  // El stock no puede ser negativo
        if (!product.getId().equals(inventoryLine.getProductId())) {
            throw new IllegalArgumentException("La línea de inventario no corresponde al producto dado.");
        }
    }
}
