package com.example.products_service.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;

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
                        .doOnSuccess(response -> System.out.println("Stock añadido con éxito"))
                        .doOnError(error -> System.err.println("Error al añadir stock: " + error.getMessage()))
                        .block();
        }
}
