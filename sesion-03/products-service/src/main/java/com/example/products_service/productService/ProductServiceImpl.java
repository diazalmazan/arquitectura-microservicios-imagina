package com.example.products_service.productService;

import com.example.products_service.model.Product;
import com.example.products_service.producer.InventoryProducer;
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
    private InventoryProducer inventoryProducer;

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
        //String url = "/add?productId=" + productSaved.getId() + "&quantity=" + 1;
        inventoryProducer.setAddStockMessage(productSaved.getId(), 1);
        // Realizar la petición POST
        /*inventoryWebClient.post()
                .uri(url)
                .retrieve()
                .bodyToMono(Void.class)
                .doOnSuccess(response -> System.out.println("Stock añadido con éxito"))
                .doOnError(error -> System.err.println("Error al añadir stock: " + error.getMessage()))
                .block();*/

        return productSaved;
    }

    /*
    private Mono<Order> fallbackAddOrder(Order order, Throwable t) {
        return Mono.error(new RuntimeException("Fallback: Unable to add order due to inventory service issue", t));
    }*/
}
