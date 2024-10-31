package com.tribune.backend.infrastructure.mappers;


import com.tribune.backend.domain.context.element.order.lineitem.product.Product;
<<<<<<< HEAD
import com.tribune.backend.infrastructure.persistance.entities.ProductEntity;
=======
import com.tribune.backend.infrastructure.ports.out.persistance.entities.ProductEntity;
>>>>>>> 1ab50b7221baaf4ecf86b42016d4bea9c6aec187
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product toProduct(ProductEntity entity);

    ProductEntity toProductEntity(Product product);
}
