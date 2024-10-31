package com.example.ecomerce.infrastructure.mappers;

import com.example.ecomerce.domain.context.product.Product;
import com.example.ecomerce.infrastructure.persistence.entity.ProductEntity;

public class ProductMapperImpl implements ProductMapper{
    @Override
    public Product toProduct(ProductEntity entity) {
        return new Product(entity.getId(), entity.getName(), entity.getPrice(), entity.getDescription());
    }

    @Override
    public ProductEntity toProductEntity(Product product) {
        return new ProductEntity(product.getId(), product.getName(), product.getPrice(), product.getDescription());
    }
}
