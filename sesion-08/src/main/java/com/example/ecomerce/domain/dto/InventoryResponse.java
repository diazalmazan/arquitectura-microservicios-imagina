package com.example.ecomerce.domain.dto;

import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class InventoryResponse {
    @NotNull
    Long stockId;
    @NotNull
    Long productId;
    @NotNull
    Number stock;
}
