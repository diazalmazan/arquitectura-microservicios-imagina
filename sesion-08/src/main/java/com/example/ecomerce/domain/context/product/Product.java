package com.example.ecomerce.domain.context.product;

import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    private Long id;

    private String name;

    private BigDecimal price;

    private String description;

}