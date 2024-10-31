package com.example.ecomerce.application.usecase;

import com.example.ecomerce.domain.context.product.Product;
import com.example.ecomerce.domain.dto.ProductRequest;
import com.example.ecomerce.domain.dto.ProductResponse;
import com.example.ecomerce.domain.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class ProductUseCaseImpl implements ProductUseCase {

    private final ProductRepository productRepository;

    @Override
    public ProductResponse crearProducto(ProductRequest productRequest) {
        Product product = new Product(productRequest.getId(), productRequest.getName(), productRequest.getPrice(), productRequest.getDescription());
        Product newProduct = productRepository.save(product);
        ProductResponse productResponse = new ProductResponse(newProduct.getId(), newProduct.getName(), newProduct.getPrice(), newProduct.getDescription());
        return productResponse;
    }

    @Override
    public List<ProductResponse> getAll() {
        return productRepository.getAll()
                .stream()
                .map(product -> new ProductResponse(product.getId(), product.getName(), product.getPrice(), product.getDescription()) )
                .collect(Collectors.toList());
    }
}
