package com.imagina.orders_service;

import com.imagina.orders_service.OrderEventProducer;
import com.imagina.orders_service.Order;
import com.imagina.orders_service.OrderEventDto;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class KafkaOrderEventProducer implements OrderEventProducer {
    private final KafkaTemplate<String, OrderEventDto> kafkaTemplate;

    @Override
    public void publishOrderCreatedEvent(Order order) {
        // Convertimos el objeto Order a un OrderEventDTO
        OrderEventDto orderEventDto = new OrderEventDto(
                order.getOrderId(),
                order.getProductId(),
                order.getQuantity(),
                order.getStatus()
        );
        // Publicamos el evento en Kafka
        kafkaTemplate.send("order-topic", orderEventDto);
    }
}
