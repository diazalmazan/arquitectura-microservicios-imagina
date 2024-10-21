package com.example.ecommerce.hexagonal.infrastructure.configuration;

import com.example.ecommerce.hexagonal.domain.repository.ProductRepository;
import com.example.ecommerce.hexagonal.domain.service.OrderDomainService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainServiceConfig {

    @Bean
    public OrderDomainService orderDomainService(ProductRepository productRepository) {
        return new OrderDomainService(productRepository);
    }
}
