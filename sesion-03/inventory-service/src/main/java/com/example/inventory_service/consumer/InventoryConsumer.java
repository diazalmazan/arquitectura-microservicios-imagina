package com.example.inventory_service.consumer;

import com.example.inventory_service.model.StockMessage;
import com.example.inventory_service.service.InventoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.function.Consumer;


@Component
@Slf4j
public class InventoryConsumer implements Consumer<Message<StockMessage>> {

    @Autowired
    private InventoryService inventoryService;

    @Override
    public void accept(Message<StockMessage> stockMessageMessage) {
        var stockMessage = Objects.requireNonNull(stockMessageMessage.getPayload());
        log.info("Received message: Product ID - " + stockMessage.getProductId() + ", Quantity - " + stockMessage.getQuantity());
        inventoryService.addProductToInventory(stockMessage.getProductId(), stockMessage.getQuantity());
    }
}
