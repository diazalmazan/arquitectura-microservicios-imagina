package com.example.products_service.config;

import com.example.products_service.client.InventoryClient;
import com.example.products_service.client.InventoryProducerImpl;
import com.example.products_service.client.InventoryWebClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientConfiguration {

    @Value("${isAsynchronous}")
    private boolean isAsynchronous;

    @Bean
    public InventoryClient inventoryClient() {
        if (isAsynchronous) {
            return new InventoryProducerImpl();
        } else {
            // Usa ObjectProvider para obtener el bean solo cuando sea necesario
            return new InventoryWebClient();
        }
    }
}
