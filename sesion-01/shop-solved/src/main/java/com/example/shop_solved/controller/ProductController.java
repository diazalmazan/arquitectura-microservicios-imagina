package com.example.shop_solved.controller;

import com.example.shop_solved.ManagementService;
import com.example.shop_solved.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ManagementService managementService;

    @GetMapping
    public List<Product> getProducts() {
        return managementService.getProducts();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {
        return managementService.getProduct(id);
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return managementService.addProduct(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        managementService.deleteProduct(id);
    }
}
