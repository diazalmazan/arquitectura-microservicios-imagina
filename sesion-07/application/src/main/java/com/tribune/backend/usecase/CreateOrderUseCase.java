package com.tribune.backend.usecase;

<<<<<<< HEAD
import com.tribune.backend.domain.dto.SingleOrderResponse;
import com.tribune.backend.domain.dto.SubmitOrderRequest;
import org.springframework.data.crossstore.ChangeSetPersister;

public interface CreateOrderUseCase {
    SingleOrderResponse processOrder(SubmitOrderRequest submitOrderRequest) throws ChangeSetPersister.NotFoundException;
=======
import com.tribune.backend.model.CreateOrderCommand;

public interface CreateOrderUseCase {
    SingleOrderResponse processOrder(CreateOrderCommand createOrderCommand);
>>>>>>> 1ab50b7221baaf4ecf86b42016d4bea9c6aec187
}
