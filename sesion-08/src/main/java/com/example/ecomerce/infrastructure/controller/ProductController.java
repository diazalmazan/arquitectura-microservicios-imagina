package com.example.ecomerce.infrastructure.controller;

import com.example.ecomerce.application.usecase.ProductUseCase;
import com.example.ecomerce.domain.dto.ProductRequest;
import com.example.ecomerce.domain.dto.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    ProductUseCase productUseCase;

    @GetMapping
    public List<ProductResponse> getAllProducts() {
        return productUseCase.getAll();
    }

    @PostMapping
    public ProductResponse createProduct(@RequestBody ProductRequest product) {
        return productUseCase.crearProducto(product);
    }

}
