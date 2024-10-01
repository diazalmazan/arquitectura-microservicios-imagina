package com.example.products_service.ProductService;

import com.example.products_service.model.Product;
import com.example.products_service.repository.ProductRepository;
import jakarta.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

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
        return productRepository.save(product);
    }
}
