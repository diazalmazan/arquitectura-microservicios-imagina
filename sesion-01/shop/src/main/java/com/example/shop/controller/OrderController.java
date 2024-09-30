package com.example.shop.controller;


import com.example.shop.ManagementService;
import com.example.shop.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@Slf4j
public class OrderController {

    @Autowired
    private ManagementService managementService;

    @GetMapping
    public List<Order> getOrders() {
        return managementService.getOrders();
    }

    @PostMapping
    public Order addOrder(@RequestBody Order order) throws Exception {
        return managementService.addOrder(order);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        managementService.deleteOrder(id);
    }
}
