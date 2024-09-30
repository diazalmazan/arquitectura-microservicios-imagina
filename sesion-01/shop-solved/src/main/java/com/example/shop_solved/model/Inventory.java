package com.example.shop_solved.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Inventory {

    private Long id;
    private Product product;
    private int quantity;
}
