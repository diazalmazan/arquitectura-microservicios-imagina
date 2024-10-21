package com.tribune.backend.domain.context;

import com.tribune.backend.domain.context.element.AggregateRoot;
import com.tribune.backend.domain.context.element.customer.Customer;
import com.tribune.backend.domain.context.element.customer.CustomerState;
import com.tribune.backend.domain.context.element.order.Order;
import com.tribune.backend.domain.context.element.order.lineitem.LineItem;
import com.tribune.backend.domain.context.element.order.lineitem.product.Product;
import com.tribune.backend.domain.dto.SingleOrderResponse;
import com.tribune.backend.domain.error.DomainException;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class CustomerOrder extends AggregateRoot<UUID> {

    private Customer customer;

    private Order order;

    private List<Product> products;

    public SingleOrderResponse validate() {

        validateCustomer();

        double totalCost = 0.0;

        for (LineItem lineItem : order.getLineItems()) {

            Product product = products.stream().filter(p -> p.getId().equals(lineItem.getProduct()))
                    .findFirst().orElseThrow(() -> new DomainException(400,
                            String.format("No product available with this id [%s].", lineItem.getProduct())));
            //calculate costs
            totalCost += product.getPrice().doubleValue() * lineItem.getQuantity();

            //check for requested quantities
            if (lineItem.getQuantity() <= product.getQuantity()) {
                //subtract the quantity
                product.setQuantity(product.getQuantity() - lineItem.getQuantity());

            } else {
                String error = String.format("Available quantity for product [%s] is %d, requested quantity was %d."
                        , product.getName(), product.getQuantity(), lineItem.getQuantity());
                throw new DomainException(400, error);
            }
        }

        //process payment

        if (order.getPayment().doubleValue() < totalCost) {
            String error = String.format("Total cost for order is %s, provided payment was %s."
                    , totalCost, order.getPayment());
            throw new DomainException(400, error);
        }

        //process Shipping


        return SingleOrderResponse.builder()
                .order(order)
                .totalCost(BigDecimal.valueOf(totalCost))
                .products(products)
                .build();
    }

    private void validateCustomer() {
        if (!customer.getState().equals(CustomerState.ACTIVE)) {
            throw new DomainException(403, String.format("Invalid Customer state - %s", customer.getState()));
        }
    }
}
