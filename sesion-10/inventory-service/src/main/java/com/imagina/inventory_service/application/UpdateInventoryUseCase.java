package com.imagina.inventory_service.application;

import com.imagina.inventory_service.application.ports.out.InventoryRepository;
import com.imagina.inventory_service.application.ports.out.ProductRepository;
import com.imagina.inventory_service.domain.Inventory;
import com.imagina.inventory_service.domain.InventoryLine;
import com.imagina.inventory_service.domain.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateInventoryUseCase {
    private final InventoryRepository inventoryRepository;
    private final ProductRepository productRepository;

    public void updateStock(Long productId, int newStock) {
        // Obtener el producto
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado."));

        // Obtener la línea de inventario asociada al producto
        InventoryLine inventoryLine = inventoryRepository.findByProductId(productId)
                .orElseThrow(() -> new IllegalArgumentException("Línea de inventario no encontrada."));

        // Crear el agregado Inventory y validar
        Inventory inventory = new Inventory(product, inventoryLine);

        // Actualizar el stock y validar
        inventory.updateStock(newStock);

        // Persistir el inventario actualizado
        inventoryRepository.save(inventoryLine);
    }
}