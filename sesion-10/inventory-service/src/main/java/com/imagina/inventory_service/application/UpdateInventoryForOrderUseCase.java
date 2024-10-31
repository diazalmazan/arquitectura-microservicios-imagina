package com.imagina.inventory_service.application;

import com.imagina.inventory_service.application.ports.out.InventoryEventProducer;
import com.imagina.inventory_service.application.ports.out.InventoryRepository;
import com.imagina.inventory_service.application.ports.out.ProductRepository;
import com.imagina.inventory_service.domain.Inventory;
import com.imagina.inventory_service.domain.InventoryLine;
import com.imagina.inventory_service.domain.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateInventoryForOrderUseCase {
    private final InventoryRepository inventoryRepository;
    private final ProductRepository productRepository;
    private final InventoryEventProducer inventoryEventProducer;

    public void updateStockForOrder(Long orderId, Long productId, int quantity) {
        // Obtener el producto
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado."));

        // Obtener la línea de inventario asociada al producto
        InventoryLine inventoryLine = inventoryRepository.findByProductId(productId)
                .orElseThrow(() -> new IllegalArgumentException("Línea de inventario no encontrada."));

        // Crear el agregado Inventory y validar
        Inventory inventory = new Inventory(product, inventoryLine);

        try {
            // Intentar actualizar el stock y validar
            inventory.updateStock(inventoryLine.getStock() - quantity);

            // Persistir la línea de inventario actualizada
            inventoryRepository.save(inventoryLine);

            // Publicar evento de orden completada (ORDER_COMPLETED)
            inventoryEventProducer.publishOrderCompletedEvent(orderId);

        } catch (IllegalArgumentException e) {
            // Si ocurre un error (stock insuficiente), publicar evento de orden cancelada (ORDER_CANCELLED)
            inventoryEventProducer.publishOrderCancelledEvent(orderId, e.getMessage());
        }
    }
}