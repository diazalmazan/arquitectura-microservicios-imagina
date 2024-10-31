package com.example.ecomerce.infrastructure.mappers;

import com.example.ecomerce.domain.context.inventory.Inventory;
import com.example.ecomerce.infrastructure.persistence.entity.InventoryEntity;

public class InventoryMapperImpl implements InventoryMapper {
    @Override
    public Inventory toStock(InventoryEntity entity) {
        return new Inventory( entity.getId(), entity.getProductId(), entity.getStock());
    }

    @Override
    public InventoryEntity toStockEntity(Inventory inventory) {
        return new InventoryEntity( inventory.getId(), inventory.getProductId(), inventory.getStock());
    }
}
