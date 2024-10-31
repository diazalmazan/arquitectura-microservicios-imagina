package com.example.ecomerce.application.usecase;

import com.example.ecomerce.domain.dto.InventoryRequest;
import com.example.ecomerce.domain.dto.InventoryResponse;

public interface InventoryUseCase {
        InventoryResponse addProductToStock(InventoryRequest inventoryRequest);
}
