package com.example.orders_service.exception;

public class InsufficientInventoryException extends RuntimeException {

    public InsufficientInventoryException(String message) {
        super(message);
    }

    public InsufficientInventoryException(String message, Throwable cause) {
        super(message, cause);
    }
}