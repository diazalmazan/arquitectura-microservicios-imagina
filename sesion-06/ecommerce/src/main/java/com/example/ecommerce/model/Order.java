package com.example.ecommerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime orderDate;
    private Double totalAmount;

    @OneToMany
    private List<Product> products;

    public Order(LocalDateTime orderDate, Double totalAmount, List<Product> products) {
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.products = products;
    }
}
