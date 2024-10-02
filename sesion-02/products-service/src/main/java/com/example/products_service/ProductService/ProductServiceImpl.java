package com.example.products_service.ProductService;

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

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(Long id) {
        return productRepository.findById(id)
                .orElseThrow(NoResultException::new);
    }

    @Override
    public Product addProduct(Product product) {
        String url = "/add?productId=" + product.getId() + "&quantity=" + 1;

        // Realizar la petición POST
        inventoryWebClient.post()
                .uri(url)
                .retrieve()
                .bodyToMono(Void.class)
                .doOnSuccess(response -> System.out.println("Stock añadido con éxito"))
                .doOnError(error -> System.err.println("Error al añadir stock: " + error.getMessage()))
                .block();

        return productRepository.save(product);
    }
}
