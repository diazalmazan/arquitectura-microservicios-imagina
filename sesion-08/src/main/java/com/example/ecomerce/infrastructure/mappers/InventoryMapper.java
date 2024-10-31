package com.example.ecomerce.infrastructure.mappers;

import com.example.ecomerce.domain.context.inventory.Inventory;
import com.example.ecomerce.infrastructure.persistence.entity.InventoryEntity;

public interface InventoryMapper {
    Inventory toStock(InventoryEntity entity);

    InventoryEntity toStockEntity(Inventory inventory);
}
