-- Crear tabla PRODUCTO
CREATE TABLE IF NOT EXISTS PRODUCT (
                          id BIGSERIAL PRIMARY KEY,
                          product_name VARCHAR(255) NOT NULL,
                          price DOUBLE PRECISION NOT NULL
);