package com.example.ecomerce.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.DynamicUpdate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DynamicUpdate
@Entity
@Table(name = "INVENTORY")
public class InventoryEntity {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @NotNull
    Long productId;
    @NotNull
    Integer stock;

}
