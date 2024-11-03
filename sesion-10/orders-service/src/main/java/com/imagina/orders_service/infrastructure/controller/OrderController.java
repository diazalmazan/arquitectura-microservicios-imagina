package com.imagina.orders_service.infrastructure.controller;

import com.imagina.orders_service.application.usecase.CreateOrderUseCase;
import com.imagina.orders_service.application.usecase.GetOrderStatusUseCase;
import com.imagina.orders_service.domain.model.Order;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@AllArgsConstructor
public class OrderController {
    private final CreateOrderUseCase createOrderUseCase;
    private final GetOrderStatusUseCase getOrderStatusUseCase;

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestParam Long productId, @RequestParam int quantity) {
        Order order = createOrderUseCase.createOrder(productId, quantity);
        return ResponseEntity.ok(order);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrderStatus(@PathVariable Long orderId) {
        return getOrderStatusUseCase.getOrderStatus(orderId)
                .map(order -> ResponseEntity.ok(order))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
