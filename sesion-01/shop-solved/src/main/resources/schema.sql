-- Crear tabla PRODUCTO
CREATE TABLE PRODUCTO (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          nombre VARCHAR(255) NOT NULL,
                          precio DOUBLE NOT NULL
);

-- Crear tabla INVENTARIO
CREATE TABLE INVENTARIO (
                            id BIGINT AUTO_INCREMENT PRIMARY KEY,
                            producto_id BIGINT,
                            cantidad INT NOT NULL,
                            CONSTRAINT fk_producto_inventario FOREIGN KEY (producto_id) REFERENCES PRODUCTO(id)
);

-- Crear tabla ORDEN
CREATE TABLE ORDEN (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       producto_id BIGINT,
                       cantidad INT NOT NULL,
                       CONSTRAINT fk_producto_orden FOREIGN KEY (producto_id) REFERENCES PRODUCTO(id)
);

-- Crear tabla PAGO
CREATE TABLE PAGO (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      orden_id BIGINT,
                      monto DOUBLE NOT NULL,
                      descuento VARCHAR(255),
                      CONSTRAINT fk_orden_pago FOREIGN KEY (orden_id) REFERENCES ORDEN(id)
);
