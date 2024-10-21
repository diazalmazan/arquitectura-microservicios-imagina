package com.example.inventory_service.consumer;

import com.example.inventory_service.model.StockMessage;
import com.example.inventory_service.service.InventoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;


@Component
@Slf4j
public class InventoryConsumer {

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private ServletWebServerApplicationContext webServerAppCtxt;

    public int getPort() {
        return webServerAppCtxt.getWebServer().getPort();
    }

    @Bean
    public Consumer<StockMessage> inventoryChannel() {
        return stockMessage -> {
            // Lógica para aumentar el inventario
            log.info("Recibido mensaje para aumentar inventario {}", stockMessage.toString());
            log.info("Received message: Product ID - " + stockMessage.getProductId() + ", Quantity - " + stockMessage.getQuantity());
            log.info("Respondiendo desde la instancia en el puerto {}", getPort());
            inventoryService.addProductToInventory(stockMessage.getProductId(), stockMessage.getQuantity());
        };
    }
}
