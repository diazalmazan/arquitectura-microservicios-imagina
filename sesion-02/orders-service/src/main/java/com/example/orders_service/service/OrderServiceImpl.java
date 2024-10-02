package com.example.orders_service.service;

import com.example.orders_service.model.Order;
import com.example.orders_service.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }


    @Override
    public Order getOrder(Long id) {
        return orderRepository.findById(id).get();
    }

    @Override
    public Order addOrder(Order order) {
        return  orderRepository.save(order);
    }

    @Override
    public void deleteOrder(Long id) {
        var order = getOrder(id);
        orderRepository.delete(order);
    }
}
