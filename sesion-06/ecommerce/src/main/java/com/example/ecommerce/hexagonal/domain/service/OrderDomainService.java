package com.example.ecommerce.hexagonal.domain.service;


import com.example.ecommerce.hexagonal.domain.model.Order;
import com.example.ecommerce.hexagonal.domain.model.Product;
import com.example.ecommerce.hexagonal.domain.repository.ProductRepository;

public class OrderDomainService {

    private final ProductRepository productRepository;

    public OrderDomainService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void validateOrder(Order order) {
        for (Product product : order.getProducts()) {
            Product storedProduct = productRepository.findById(product.getId())
                    .orElseThrow(() -> new RuntimeException("Producto no disponible"));
            if (storedProduct.getQuantity() < product.getQuantity()) {
                throw new RuntimeException("Cantidad insuficiente de producto: " + product.getName());
            }
        }
    }
}
