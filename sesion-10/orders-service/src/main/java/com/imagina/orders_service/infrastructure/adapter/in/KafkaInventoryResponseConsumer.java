package com.imagina.orders_service.infrastructure.adapter.in;

import com.imagina.orders_service.application.usecase.UpdateOrderStatusUseCase;
import com.imagina.orders_service.infrastructure.model.InventoryResponseEventDto;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;



@Component
@AllArgsConstructor
public class KafkaInventoryResponseConsumer {
    private final UpdateOrderStatusUseCase updateOrderStatusUseCase;

    @KafkaListener(topics = "inventory-response-topic", groupId = "order-group")
    public void handleInventoryResponseEvent(InventoryResponseEventDto event) {
        updateOrderStatusUseCase.updateOrderStatus(event.getOrderId(), event.getStatus());
    }
}
