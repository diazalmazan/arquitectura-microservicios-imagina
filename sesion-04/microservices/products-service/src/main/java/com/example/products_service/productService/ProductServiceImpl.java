package com.example.products_service.productService;

import com.example.products_service.client.InventoryClient;
import com.example.products_service.model.Product;
import com.example.products_service.repository.ProductRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import jakarta.persistence.NoResultException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private WebClient inventoryWebClient;

    @Autowired
    private InventoryClient inventoryClient;

    @Override
    @Cacheable(value = "products")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    @Cacheable(value = "product", key = "#id")
    public Product getProduct(Long id) {
        return productRepository.findById(id)
                .orElseThrow(NoResultException::new);
    }

    @Transactional
    @CircuitBreaker(name = "inventoryService", fallbackMethod = "fallbackAddStock")
    @CacheEvict(value = "products", allEntries = true)
    public Product addProduct(Product product) {
        var productSaved = productRepository.save(product);

        try {
            inventoryClient.addStock(productSaved.getId(), 1);
        } catch (Exception e) {
            log.error("Failed to add stock for product {}: {}", productSaved.getId(), e.getMessage());
            // Optional: throw a specific exception if rollback is required
            throw e;
        }
        return productSaved;
    }

    // Fallback method called when CircuitBreaker is open or an error occurs
    private Product fallbackAddStock(Product product, Throwable t) {
        log.warn("Fallback triggered for adding stock to product {}: {}", product.getId(), t.getMessage());
        // Handle the fallback logic as necessary (e.g., returning a response with a different status)
        return product;
    }
}
