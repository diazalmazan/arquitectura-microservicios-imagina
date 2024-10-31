package com.tribune.backend.usecase;

import com.tribune.backend.domain.context.element.customer.Customer;
import com.tribune.backend.domain.dto.SingleOrderResponse;
import com.tribune.backend.domain.dto.SubmitOrderRequest;
import com.tribune.backend.domain.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;


public class CreateOrderUseCaseImpl implements CreateOrderUseCase{

    @Autowired
    CustomerRepository customerRepository;
    @Override
    public SingleOrderResponse processOrder(SubmitOrderRequest submitOrderRequest) throws ChangeSetPersister.NotFoundException {
        // recuperar cliente
        Customer customer = customerRepository.findById(submitOrderRequest.getUser())
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());


        // validar cliente

        // aplicar descuento

        // cambiar esto de la orden

        // validar la orden

        // pulicar un evento de envio de la orden

        return null;
    }
}
