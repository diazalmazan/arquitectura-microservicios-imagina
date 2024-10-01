package com.example.shop_solved.service;

import com.example.shop_solved.model.Inventory;
import com.example.shop_solved.repository.InventoryRepository;
import com.example.shop_solved.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;
    @Autowired
    private ProductRepository productRepository;

    public void addProductToInventory(Long productId, int quantity) {
        var product = productRepository.findById(productId);
        var inventory = new Inventory();
        inventory.setProduct(product.get());
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
}
