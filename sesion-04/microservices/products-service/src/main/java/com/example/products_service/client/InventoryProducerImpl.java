package com.example.products_service.client;

import com.example.products_service.model.StockMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;

@Slf4j
public class InventoryProducerImpl implements InventoryClient {

    @Autowired
    private StreamBridge streamBridge;

    public void addStock(Long productId, int quantity) {
        log.info("Procesando mensaje para producto {} con cantidad {}", productId, quantity);
        StockMessage stockMessage = new StockMessage(productId, quantity);
        streamBridge.send("productChannel-out-0", stockMessage);
    }
}
