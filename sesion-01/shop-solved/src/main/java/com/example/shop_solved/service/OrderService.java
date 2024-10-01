package com.example.shop_solved.service;

import com.example.shop_solved.model.Order;
import com.example.shop_solved.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }


    public Order getOrder(Long id) {
        return orderRepository.findById(id).get();
    }

    public Order addOrder(Order order) {
        return  orderRepository.save(order);
    }

    public void deleteOrder(Long id) {
        var order = getOrder(id);
        orderRepository.delete(order);
    }
}
