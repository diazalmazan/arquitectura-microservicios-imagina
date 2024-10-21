package com.tribune.backend.usecase;

import com.tribune.backend.model.CreateOrderCommand;

public interface CreateOrderUseCase {
    SingleOrderResponse processOrder(CreateOrderCommand createOrderCommand);
}
