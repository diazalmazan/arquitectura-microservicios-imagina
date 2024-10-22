package com.imagina.inventory_service.infrastructure.adapters.in;

import com.imagina.inventory_service.application.UpdateInventoryUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
@AllArgsConstructor
public class InventoryController {
    private final UpdateInventoryUseCase updateInventoryUseCase;

    @PutMapping("/{productId}/stock")
    public ResponseEntity<String> updateStock(@PathVariable Long productId, @RequestParam int stock) {
        try {
            updateInventoryUseCase.updateStock(productId, stock);
            return ResponseEntity.ok("Stock actualizado correctamente");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
