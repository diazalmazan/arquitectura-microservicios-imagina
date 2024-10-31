package com.example.ecomerce.application.usecase;

import com.example.ecomerce.domain.context.inventory.Inventory;
import com.example.ecomerce.domain.dto.InventoryRequest;
import com.example.ecomerce.domain.dto.InventoryResponse;
import com.example.ecomerce.domain.repository.InventoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@AllArgsConstructor
public class InventoryUseCaseImpl implements InventoryUseCase {

    private final InventoryRepository inventoryRepository;
    @Override
    public InventoryResponse addProductToStock(InventoryRequest inventoryRequest) {

        Inventory inventory  = inventoryRepository.get(inventoryRequest.getProductId());
        Integer cantidad = inventory.getStock() + inventoryRequest.getCantidad();
        inventory.setStock(cantidad);
        Inventory newInventory = inventoryRepository.save(inventory);

        InventoryResponse stockResponse = new InventoryResponse(newInventory.getId(), newInventory.getProductId(), newInventory.getStock());

        return stockResponse;
    }
}
