-- Datos iniciales para la tabla PRODUCTO
INSERT INTO PRODUCTO (nombre, precio) VALUES ('Laptop', 1500);
INSERT INTO PRODUCTO (nombre, precio) VALUES ('Smartphone', 800);
INSERT INTO PRODUCTO (nombre, precio) VALUES ('Tablet', 500);

-- Datos iniciales para la tabla INVENTARIO
INSERT INTO INVENTARIO (producto_id, cantidad) VALUES (1, 10);
INSERT INTO INVENTARIO (producto_id, cantidad) VALUES (2, 15);
INSERT INTO INVENTARIO (producto_id, cantidad) VALUES (3, 5);

-- Datos iniciales para la tabla ORDEN
INSERT INTO ORDEN (producto_id, cantidad) VALUES (1, 3);
INSERT INTO ORDEN (producto_id, cantidad) VALUES (2, 2);

-- Datos iniciales para la tabla PAGO
INSERT INTO PAGO (orden_id, monto, descuento) VALUES (1, 4500, 'CHRISTMAS');
INSERT INTO PAGO (orden_id, monto, descuento) VALUES (2, 1600, NULL);