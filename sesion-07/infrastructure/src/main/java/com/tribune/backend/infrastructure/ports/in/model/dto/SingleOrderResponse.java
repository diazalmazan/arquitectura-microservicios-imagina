package com.tribune.backend.infrastructure.ports.in.model.dto;


import com.tribune.backend.domain.context.element.order.Order;
import com.tribune.backend.domain.context.element.order.lineitem.product.Product;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class SingleOrderResponse {

    private Order order;

    private BigDecimal totalCost;

    private List<Product> products;

}
