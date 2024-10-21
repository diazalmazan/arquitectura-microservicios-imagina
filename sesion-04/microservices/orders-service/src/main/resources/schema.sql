-- Crear tabla ORDEN
CREATE TABLE IF NOT EXISTS ORDERS (
                       id BIGSERIAL PRIMARY KEY,
                       producto_id BIGINT,
                       cantidad INT NOT NULL
);