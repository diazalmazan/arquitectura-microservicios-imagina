package com.imagina.inventory_service.infrastructure.adapters.in;


import com.imagina.inventory_service.application.UpdateInventoryForOrderUseCase;
import com.imagina.inventory_service.application.ports.out.InventoryEventProducer;
import com.imagina.inventory_service.infrastructure.model.dto.OrderEventDto;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class KafkaOrderConsumer {
    private final UpdateInventoryForOrderUseCase updateInventoryForOrderUseCase;
    private final InventoryEventProducer inventoryEventProducer;

    @KafkaListener(topics = "order-topic", groupId = "inventory-group")
    public void handleOrderCreatedEvent(OrderEventDto orderEventDto) {
        try {
            // Intentar actualizar el stock
            updateInventoryForOrderUseCase.updateStockForOrder(orderEventDto.getOrderId(), orderEventDto.getProductId(), orderEventDto.getQuantity());
            // Publicar evento de Orden Completada
            inventoryEventProducer.publishOrderCompletedEvent(orderEventDto.getOrderId());
        } catch (IllegalArgumentException e) {
            // Si no hay suficiente stock, publicar evento de Orden Cancelada
            inventoryEventProducer.publishOrderCancelledEvent(orderEventDto.getOrderId(), e.getMessage());
        }
    }
}
