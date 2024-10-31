package com.example.ecomerce.application.usecase;

import com.example.ecomerce.domain.dto.ProductRequest;
import com.example.ecomerce.domain.dto.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductUseCase {
    ProductResponse crearProducto(ProductRequest productRequest);

    List<ProductResponse> getAll();
}
