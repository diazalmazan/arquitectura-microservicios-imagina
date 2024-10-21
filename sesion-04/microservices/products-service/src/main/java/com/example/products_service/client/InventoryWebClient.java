package com.example.products_service.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
public class InventoryWebClient implements InventoryClient {

        @Autowired
        private WebClient inventoryWebClient;

        public void addStock(Long productId, int quantity) {
                inventoryWebClient.post()
                        .uri(uriBuilder -> uriBuilder
                                .path("/api/inventory/add")
                                .queryParam("productId", productId)
                                .queryParam("quantity", quantity)
                                .build())
                        .retrieve()
                        .bodyToMono(Void.class)
                        .doOnSuccess(response -> log.info("Stock añadido con éxito"))
                        .doOnError(error -> {
                                log.error("Error al añadir stock: " + error.getMessage());
                                throw new RuntimeException();
                                }
                        )
                        .block();
        }
}
