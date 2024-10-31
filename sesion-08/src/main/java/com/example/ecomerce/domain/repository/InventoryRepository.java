package com.example.ecomerce.domain.repository;

import com.example.ecomerce.domain.context.inventory.Inventory;

public interface InventoryRepository {
    Inventory save(Inventory inventory);
    Inventory get(Long productId);
}
