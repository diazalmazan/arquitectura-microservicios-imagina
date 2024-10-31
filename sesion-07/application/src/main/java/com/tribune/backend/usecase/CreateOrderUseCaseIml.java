package com.tribune.backend.usecase;

import com.tribune.backend.domain.context.CustomerOrder;
import com.tribune.backend.domain.context.element.customer.Customer;
import com.tribune.backend.domain.context.element.order.Order;
import com.tribune.backend.domain.context.element.order.lineitem.LineItem;
import com.tribune.backend.domain.context.element.order.lineitem.product.Product;
import com.tribune.backend.domain.dto.SingleOrderResponse;
import com.tribune.backend.domain.dto.SubmitOrderRequest;
import com.tribune.backend.domain.enums.OrderStatus;
import com.tribune.backend.domain.repository.CustomerRepository;
import com.tribune.backend.domain.repository.OrderRepository;
import com.tribune.backend.domain.repository.ProductRepository;
import com.tribune.backend.error.NotFoundException;
import com.tribune.backend.model.CreateOrderCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class CreateOrderUseCaseIml implements CreateOrderUseCase {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public SingleOrderResponse processOrder(CreateOrderCommand createOrderCommand) {

        // Recuperar Cliente
        log.info("Process order - {}", createOrderCommand);
        Customer customer = customerRepository.findById(createOrderCommand.getUser())
                .orElseThrow(() -> new NotFoundException("No customer was found by the given id"));

        List<Long> ids = createOrderCommand.getOrder().getLineItems()
                .stream().map(LineItem::getProduct).toList();
        log.info("product ids:{}", ids);

        List<Product> products = productRepository.getAllByIdIn(ids);

        log.info("products - {}", products);


        Order order = createOrderCommand.getOrder();

        order.setStatus(OrderStatus.INITIALIZED);
        orderRepository.saveAndFlush(order);

        UUID customerOrderContextUuid = UUID.randomUUID();
        CustomerOrder customerOrder = CustomerOrder.builder()
                .id(customerOrderContextUuid)
                .customer(customer)
                .order(createOrderCommand.getOrder())
                .products(products)
                .build();

        SingleOrderResponse response = customerOrder.validate();

        productRepository.saveAll(response.getProducts());

        order.setStatus(OrderStatus.SUBMITTED);

        Long orderId = orderRepository.save(order).getId();

        // Emitir evento de envío

        return response;
    }
}
