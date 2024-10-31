package com.tribune.backend.infrastructure.mappers;


import com.tribune.backend.domain.context.element.order.lineitem.LineItem;
<<<<<<< HEAD
import com.tribune.backend.infrastructure.persistance.entities.LineItemEntity;
=======
import com.tribune.backend.infrastructure.ports.out.persistance.entities.LineItemEntity;
>>>>>>> 1ab50b7221baaf4ecf86b42016d4bea9c6aec187
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LineItemMapper {

    @Mapping(source = "product.id", target = "product")
    @Mapping(source = "customerOrder.id", target = "order")
    LineItem toLineItem(LineItemEntity entity);

    @Mapping(source = "product", target = "product.id")
    @Mapping(source = "order", target = "customerOrder.id")
    LineItemEntity toLineItemEntity(LineItem lineItem);

}
