-- Crear tabla PAGO
CREATE TABLE PAYMENTS (
                      id BIGSERIAL PRIMARY KEY,
                      order_id BIGINT,
                      amount DOUBLE PRECISION NOT NULL,
                      discount VARCHAR(255)
);
