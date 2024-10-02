package com.example.products_service.producer;

import com.example.products_service.model.StockMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class InventoryProducer {

    @Autowired
    private StreamBridge streamBridge;

    public void setAddStockMessage(Long productId, int quantity) {
        log.info("Procesando mensaje para producto {} con cantidad {}", productId, quantity);
        StockMessage stockMessage = new StockMessage(productId, quantity);
        streamBridge.send("inventoryChannel-out-0", stockMessage);
    }
}
