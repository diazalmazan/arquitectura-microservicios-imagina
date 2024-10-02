package com.example.products_service.productService;

import com.example.products_service.client.InventoryClient;
import com.example.products_service.model.Product;
import com.example.products_service.repository.ProductRepository;
import jakarta.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private WebClient inventoryWebClient;

    @Autowired
    private InventoryClient inventoryClient;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(Long id) {
        return productRepository.findById(id)
                .orElseThrow(NoResultException::new);
    }

    //@CircuitBreaker(name = "inventoryService", fallbackMethod = "fallbackAddOrder")
    @Override
    public Product addProduct(Product product) {
        var productSaved = productRepository.save(product);
        inventoryClient.addStock(productSaved.getId(), 1);
        return productSaved;
    }

    /*
    private Mono<Order> fallbackAddOrder(Order order, Throwable t) {
        return Mono.error(new RuntimeException("Fallback: Unable to add order due to inventory service issue", t));
    }*/
}
