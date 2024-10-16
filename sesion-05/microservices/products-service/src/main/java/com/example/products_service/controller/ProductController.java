package com.example.products_service.controller;

import com.example.products_service.model.Product;
import com.example.products_service.productService.ProductService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private ProductService productService;

    private final Counter pedidoCounter;

    public ProductController(ProductService productService, MeterRegistry meterRegistry) {
        this.productService = productService;
        this.pedidoCounter = meterRegistry.counter("pedidos_totales");
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProduct(id);
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        pedidoCounter.increment();
        return productService.addProduct(product);
    }
}
