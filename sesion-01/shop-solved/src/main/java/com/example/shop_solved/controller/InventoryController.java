package com.example.shop_solved.controller;

import com.example.shop_solved.ManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private ManagementService managementService;

    @GetMapping("/{productId}")
    public int getStock(@PathVariable Long productId) {
        return managementService.getProductStock(productId);
    }

    @PostMapping("/add")
    public void addStock(@RequestParam Long productId, @RequestParam int quantity) {
        managementService.addProductToInventory(productId, quantity);
    }

    @PostMapping("/reduce")
    public void reduceStock(@RequestParam Long productId, @RequestParam int quantity) {
        managementService.reduceProductStock(productId, quantity);
    }
}
