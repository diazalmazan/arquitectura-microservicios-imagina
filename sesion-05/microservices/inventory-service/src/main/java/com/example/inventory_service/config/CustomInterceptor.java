package com.example.inventory_service.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@Slf4j
public class CustomInterceptor implements HandlerInterceptor {

    @Autowired
    private ServletWebServerApplicationContext webServerAppCtxt;

    public int getPort() {
        return webServerAppCtxt.getWebServer().getPort();
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("Llamada al método del controlador {} ", handler);
        log.info("Esta instancia está corriendo en el puerto {}", getPort());
        return true; // Permite continuar con la ejecución
    }
}