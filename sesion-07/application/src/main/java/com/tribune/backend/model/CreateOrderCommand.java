package com.tribune.backend.model;

import com.tribune.backend.domain.context.element.order.Order;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CreateOrderCommand {
    @NotNull
    private Long user;
    @NotNull
    private Long address;
    @NotNull
    private Order order;
}
