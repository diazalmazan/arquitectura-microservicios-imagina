package com.tribune.backend.infrastructure.mappers;


import com.tribune.backend.domain.context.element.order.Order;
<<<<<<< HEAD
import com.tribune.backend.infrastructure.persistance.entities.OrderEntity;
=======
import com.tribune.backend.infrastructure.ports.out.persistance.entities.OrderEntity;
>>>>>>> 1ab50b7221baaf4ecf86b42016d4bea9c6aec187
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = LineItemMapper.class)
public interface OrderMapper {

    Order toOrder(OrderEntity entity);

    OrderEntity toOrderEntity(Order order);
}
