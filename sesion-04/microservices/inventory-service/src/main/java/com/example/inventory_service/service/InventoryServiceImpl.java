package com.example.inventory_service.service;

import com.example.inventory_service.model.Inventory;
import com.example.inventory_service.repository.InventoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;



    public void addProductToInventory(Long productId, int quantity) {
        var inventory = new Inventory();
        inventory.setProductId(productId);
        inventory.setQuantity(quantity);
        inventoryRepository.save(inventory);
    }

    public void reduceProductStock(Long productId, int quantity) {
        var inventory = inventoryRepository.findByProductId(productId);
        inventory.setQuantity(quantity);
        inventoryRepository.save(inventory);
    }

    public int getProductStock(Long productId) {
        return inventoryRepository.findByProductId(productId).getQuantity();
    }

    @Override
    public List<Inventory> getAllProductsInventory() {
        return inventoryRepository.findAll();
    }
}
