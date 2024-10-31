package com.example.ecomerce.domain.context.inventory;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Inventory {
    Long id;
     Long productId;
     Integer stock;
}
