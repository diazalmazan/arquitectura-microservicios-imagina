package com.example.products_service.client;

public interface InventoryClient {

    void addStock(Long productId, int quantity);
}
