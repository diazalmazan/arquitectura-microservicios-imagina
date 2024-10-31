package com.example.ecommerce.hexagonal.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Long id;
    private LocalDateTime orderDate;
    private Double totalAmount;
    private List<Product> products;
}
