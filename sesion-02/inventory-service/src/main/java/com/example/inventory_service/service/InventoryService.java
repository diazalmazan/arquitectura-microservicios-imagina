package com.example.inventory_service.service;

import com.example.inventory_service.model.Inventory;

import java.util.List;

public interface InventoryService {

    void addProductToInventory(Long productId, int quantity);

    void reduceProductStock(Long productId, int quantity);

    int getProductStock(Long productId);

    List<Inventory> getAllProductsInventory();
}
