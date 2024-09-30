package com.example.shop_solved.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Payment {

    private Long id;
    private Order order;
    private double amount;
    private String discount;
}
