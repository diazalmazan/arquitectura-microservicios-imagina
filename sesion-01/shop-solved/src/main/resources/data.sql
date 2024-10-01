-- Datos iniciales para la tabla PRODUCT
INSERT INTO PRODUCT (name, price) VALUES ('Laptop', 1500);
INSERT INTO PRODUCT (name, price) VALUES ('Smartphone', 800);
INSERT INTO PRODUCT (name, price) VALUES ('Tablet', 500);

-- Datos iniciales para la tabla INVENTORY
INSERT INTO INVENTORY (product_id, quantity) VALUES (1, 10);
INSERT INTO INVENTORY (product_id, quantity) VALUES (2, 15);
INSERT INTO INVENTORY (product_id, quantity) VALUES (3, 5);

-- Datos iniciales para la tabla ORDERS
INSERT INTO ORDERS (product_id, quantity) VALUES (1, 3);
INSERT INTO ORDERS (product_id, quantity) VALUES (2, 2);

-- Datos iniciales para la tabla PAYMENT
INSERT INTO PAYMENT (order_id, amount, discount) VALUES (1, 4500, 'CHRISTMAS');
INSERT INTO PAYMENT (order_id, amount, discount) VALUES (2, 1600, NULL);