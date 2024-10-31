package com.example.ecomerce.infrastructure.config;

import com.example.ecomerce.application.usecase.InventoryUseCase;
import com.example.ecomerce.application.usecase.InventoryUseCaseImpl;
import com.example.ecomerce.application.usecase.ProductUseCase;
import com.example.ecomerce.application.usecase.ProductUseCaseImpl;
import com.example.ecomerce.domain.context.product.Product;
import com.example.ecomerce.domain.repository.InventoryRepository;
import com.example.ecomerce.domain.repository.ProductRepository;
import com.example.ecomerce.infrastructure.mappers.InventoryMapper;
import com.example.ecomerce.infrastructure.mappers.InventoryMapperImpl;
import com.example.ecomerce.infrastructure.mappers.ProductMapper;
import com.example.ecomerce.infrastructure.mappers.ProductMapperImpl;
import com.example.ecomerce.infrastructure.persistence.entity.ProductEntity;
import com.example.ecomerce.infrastructure.persistence.repository.InventoryRepositoryImpl;
import com.example.ecomerce.infrastructure.persistence.repository.JpaInventoryRepository;
import com.example.ecomerce.infrastructure.persistence.repository.JpaProductRepository;
import com.example.ecomerce.infrastructure.persistence.repository.ProductRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Autowired
    private JpaProductRepository jpaProductRepository;
    @Autowired
    private JpaInventoryRepository jpaInventoryRepository;

    @Bean
    public ProductUseCase getProductUseCase(){

        return new ProductUseCaseImpl(this.getProductRepository());
    }

    @Bean
    public ProductRepository getProductRepository(){
        return new ProductRepositoryImpl(jpaProductRepository, this.getProductMapper());
    }

    @Bean
    public ProductMapper getProductMapper(){
        return new ProductMapperImpl();
    }

    @Bean
    public InventoryUseCase getInventoryUseCase(){
        return new InventoryUseCaseImpl(this.getInventoryRepository());
    }

    @Bean
    public InventoryRepository getInventoryRepository(){
        return new InventoryRepositoryImpl(this.getJpaInventoryRepository(), this.getInventoryMapper());
    }

    @Bean
    public JpaInventoryRepository getJpaInventoryRepository() {
        return jpaInventoryRepository;
    }
    @Bean
    public InventoryMapper getInventoryMapper(){
        return new InventoryMapperImpl();
    }

}
