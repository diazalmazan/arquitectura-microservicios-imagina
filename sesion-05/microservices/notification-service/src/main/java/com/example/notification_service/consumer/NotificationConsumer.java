package com.example.notification_service.consumer;

import com.example.notification_service.model.StockMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
@Slf4j
public class NotificationConsumer {

    @Bean
    public Consumer<StockMessage> notificationChannel() {
        return stockMessage -> {
            // Lógica para enviar notificación
            log.info("Recibido mensaje para enviar notificación: {}", stockMessage.toString());
        };
    }
}
