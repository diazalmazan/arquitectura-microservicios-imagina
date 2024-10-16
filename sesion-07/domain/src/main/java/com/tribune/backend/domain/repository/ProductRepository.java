package com.tribune.backend.domain.repository;

import com.tribune.backend.domain.context.element.order.lineitem.product.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> getAllByIdIn(List<Long> ids);
    void saveAll(List<Product> products);
}
