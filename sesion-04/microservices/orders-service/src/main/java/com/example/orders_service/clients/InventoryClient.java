package com.example.orders_service.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "inventory-service")
@Component
public interface InventoryClient {

    @GetMapping("/api/inventory/{productId}")
    int getStock(@PathVariable Long productId);
}
