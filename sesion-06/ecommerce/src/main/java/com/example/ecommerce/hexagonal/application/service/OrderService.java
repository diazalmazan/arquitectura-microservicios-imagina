package com.example.ecommerce.hexagonal.application.service;

import com.example.ecommerce.hexagonal.domain.model.Order;
import com.example.ecommerce.hexagonal.domain.repository.OrderRepository;
import com.example.ecommerce.hexagonal.domain.service.OrderDomainService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderDomainService orderDomainService;

    public OrderService(OrderRepository orderRepository, OrderDomainService orderDomainService) {
        this.orderRepository = orderRepository;
        this.orderDomainService = orderDomainService;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    @Transactional
    public Order createOrder(Order order) {
        // Validar el pedido en el servicio de dominio
        orderDomainService.validateOrder(order);
        // Guardar el pedido si la validación es exitosa
        return orderRepository.save(order);
    }
}
