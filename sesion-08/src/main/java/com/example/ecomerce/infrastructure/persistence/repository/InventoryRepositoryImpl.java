package com.example.ecomerce.infrastructure.persistence.repository;

import com.example.ecomerce.domain.context.inventory.Inventory;
import com.example.ecomerce.domain.repository.InventoryRepository;
import com.example.ecomerce.infrastructure.mappers.InventoryMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@AllArgsConstructor
public class InventoryRepositoryImpl implements InventoryRepository {

    private final JpaInventoryRepository jpaInventoryRepository;

    private final InventoryMapper inventoryMapper;

    @Override
    public Inventory save(Inventory inventory) {
        return  inventoryMapper.toStock(jpaInventoryRepository.save(inventoryMapper.toStockEntity(inventory)));
    }

    @Override
    public Inventory get(Long productId) {
        return inventoryMapper.toStock( jpaInventoryRepository.findByProductId(productId));
    }
}
