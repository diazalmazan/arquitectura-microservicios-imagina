package com.example.inventory_service.controller;


import com.example.inventory_service.model.Inventory;
import com.example.inventory_service.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping
    public List<Inventory> getStock() {
        return inventoryService.getAllProductsInventory();
    }

    @GetMapping("/{productId}")
    public int getStock(@PathVariable Long productId) {
        return inventoryService.getProductStock(productId);
    }

    @PostMapping("/add")
    public void addStock(@RequestParam Long productId, @RequestParam int quantity) {
        inventoryService.addProductToInventory(productId, quantity);
    }

    @PostMapping("/reduce")
    public void reduceStock(@RequestParam Long productId, @RequestParam int quantity) {
        inventoryService.reduceProductStock(productId, quantity);
    }
}
