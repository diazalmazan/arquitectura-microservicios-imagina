package com.tribune.backend.infrastructure.adapters;


import com.tribune.backend.domain.context.element.order.lineitem.product.Product;
import com.tribune.backend.domain.repository.ProductRepository;
import com.tribune.backend.infrastructure.mappers.ProductMapper;
import com.tribune.backend.infrastructure.ports.out.persistance.repository.JpaProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class ProductRepositoryImpl implements ProductRepository {

    @Autowired
    private JpaProductRepository jpaProductRepository;
    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> getAllByIdIn(List<Long> ids) {
        return jpaProductRepository.getAllByIdIn(ids)
                .stream()
                .map(productEntity -> productMapper.toProduct(productEntity))
                .collect(Collectors.toList());
    }

    @Override
    public void saveAll(List<Product> products) {
        jpaProductRepository.saveAll(products
                .stream()
                .map(product -> productMapper.toProductEntity(product))
                .collect(Collectors.toList()));
    }
}
