package com.example.ecommerce.mvc.service;

import com.example.ecommerce.mvc.model.Order;
import com.example.ecommerce.mvc.model.Product;
import com.example.ecommerce.mvc.repository.OrderRepository;
import com.example.ecommerce.mvc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;

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

    public Order createOrder(Order order) {
        // Verificar disponibilidad de los productos
        for(Product product: order.getProducts()) {
            Product storedProduct = productRepository.findById(product.getId())
                    .orElseThrow(() -> new RuntimeException("Producto no disponible"));
            if(storedProduct.getQuantity() < product.getQuantity()) {
                throw new RuntimeException("Cantidad insuficiente de producto: " + product.getName());
            }
        }

        // Guardar el pedido si todo esta bien
        return orderRepository.save(order);
    }
}
