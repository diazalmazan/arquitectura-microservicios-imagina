package com.example.ecomerce.infrastructure.mappers;
import com.example.ecomerce.domain.context.product.Product;
import com.example.ecomerce.infrastructure.persistence.entity.ProductEntity;

public interface ProductMapper {

    Product toProduct(ProductEntity entity);

    ProductEntity toProductEntity(Product product);
}