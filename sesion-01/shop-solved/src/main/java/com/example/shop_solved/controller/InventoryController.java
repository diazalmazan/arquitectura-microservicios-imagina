package com.example.shop_solved.controller;

import com.example.shop_solved.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

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
