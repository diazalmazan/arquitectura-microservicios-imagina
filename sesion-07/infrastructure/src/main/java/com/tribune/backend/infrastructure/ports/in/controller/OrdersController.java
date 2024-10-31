package com.tribune.backend.infrastructure.ports.in.controller;

import com.tribune.backend.error.NotFoundException;
import com.tribune.backend.infrastructure.mappers.CreateOrderMapper;
import com.tribune.backend.infrastructure.ports.in.model.dto.GenericResponse;
import com.tribune.backend.infrastructure.ports.in.model.dto.SingleOrderResponse;
import com.tribune.backend.infrastructure.ports.in.model.dto.SubmitOrderRequest;
import com.tribune.backend.usecase.CreateOrderUseCase;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor
@RequestMapping("/v1/orders")
@RestController
public class OrdersController implements OrderControllerInterface {

    private final CreateOrderUseCase createOrderUseCase;
    private final CreateOrderMapper createOrderMapper;

    @PostMapping("/submitOrder")
    public GenericResponse<SingleOrderResponse> placeOrder(@Valid @RequestBody SubmitOrderRequest createOrderRequest) throws NotFoundException {

        SingleOrderResponse orderResponse = createOrderUseCase.processOrder(createOrderMapper.toCreateOrderCommand(createOrderRequest));


        return GenericResponse.<SingleOrderResponse>builder()
                .code(201)
                .data(orderResponse)
                .message("Created!")
                .build();
    }

}