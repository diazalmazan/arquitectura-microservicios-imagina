-- Insertar productos
INSERT INTO product (id, name, price, description) VALUES (1, 'Laptop', 1200.00, 'Laptop de gama alta');
INSERT INTO product (id, name, price, description) VALUES (2, 'Headphones', 150.00, 'Auriculares inalámbricos');
INSERT INTO product (id, name, price, description) VALUES (3, 'Keyboard', 75.00, 'Teclado mecánico');

-- Insertar líneas de inventario
INSERT INTO inventory (id, productId, stock) VALUES (1, 1, 50);
INSERT INTO inventory (id, productId, stock) VALUES (2, 2, 200);
INSERT INTO inventory (id, productId, stock) VALUES (3, 3, 100);


