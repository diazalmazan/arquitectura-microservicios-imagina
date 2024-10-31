package com.example.ecomerce.infrastructure.persistence.repository;

import com.example.ecomerce.domain.context.product.Product;
import com.example.ecomerce.domain.repository.ProductRepository;
import com.example.ecomerce.infrastructure.mappers.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {

    private final JpaProductRepository jpaProductRepository;

    private final ProductMapper productMapper;

    @Override
    public List<Product> getAll() {

        return  jpaProductRepository.findAll()
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

    @Override
    public Product save(Product product) {
        return productMapper.toProduct(jpaProductRepository.save(productMapper.toProductEntity(product)));
    }

    @Override
    public Product getById(Long id) {
        return productMapper.toProduct( jpaProductRepository.getById(id));
    }

}
