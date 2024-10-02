-- Crear tabla PRODUCTO
CREATE TABLE PRODUCT IF NOT EXISTS (
                          id BIGSERIAL PRIMARY KEY,
                          product_name VARCHAR(255) NOT NULL,
                          price DOUBLE NOT NULL
);