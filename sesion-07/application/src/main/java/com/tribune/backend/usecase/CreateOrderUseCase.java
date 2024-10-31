package com.tribune.backend.usecase;

import com.tribune.backend.domain.dto.SingleOrderResponse;
import com.tribune.backend.domain.dto.SubmitOrderRequest;
import org.springframework.data.crossstore.ChangeSetPersister;

public interface CreateOrderUseCase {
    SingleOrderResponse processOrder(SubmitOrderRequest submitOrderRequest) throws ChangeSetPersister.NotFoundException;
}
