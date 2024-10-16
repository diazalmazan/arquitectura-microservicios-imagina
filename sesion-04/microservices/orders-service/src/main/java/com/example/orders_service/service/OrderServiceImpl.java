package com.example.orders_service.service;

import com.example.orders_service.clients.InventoryClient;
import com.example.orders_service.exception.InsufficientInventoryException;
import com.example.orders_service.model.Order;
import com.example.orders_service.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private WebClient inventoryWebClient;

    @Autowired
    private InventoryClient inventoryClient;

    @Override
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }


    @Override
    public Order getOrder(Long id) {
        return orderRepository.findById(id).get();
    }

    @Override
    public Mono<Order> addOrder(Order order) {
        int quantity = inventoryClient.getStock(order.getProductId());
        if(quantity < order.getQuantity()) {
            log.error("Insufficient inventory for product ID: {}", order.getProductId());
            return Mono.error(new InsufficientInventoryException("Insufficient inventory for product ID: " + order.getProductId()));
        } else {
            return Mono.fromCallable(() -> orderRepository.save(order));
        }
        /*
        return inventoryWebClient.get()
                .uri("/" + order.getProductId())
                .retrieve()
                .bodyToMono(Integer.class)
                .flatMap(productQuantity -> {
                    if (productQuantity < order.getQuantity()) {
                        log.error("Insufficient inventory for product ID: {}", order.getProductId());
                        return Mono.error(new InsufficientInventoryException("Insufficient inventory for product ID: " + order.getProductId()));
                    }
                    // Enviar un mensaje para añadir un pago
                    return Mono.fromCallable(() -> orderRepository.save(order));
                })
                .onErrorResume(e -> {
                    log.error("Error occurred while adding order");
                    return Mono.error(new RuntimeException("Error occurred while adding order", e));
                });*/
    }

    @Override
    public void deleteOrder(Long id) {
        var order = getOrder(id);
        orderRepository.delete(order);
    }
}
