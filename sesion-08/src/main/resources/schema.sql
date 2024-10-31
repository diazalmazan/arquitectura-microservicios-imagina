-- Crear tabla PRODUCTO
CREATE TABLE IF NOT EXISTS PRODUCT (
                          id INT  PRIMARY KEY NOT NULL,
                          name VARCHAR(255) NOT NULL,
                          price DOUBLE NOT NULL,
                          description VARCHAR(500) NOT NULL
);

-- Crear tabla INVENTORY
CREATE TABLE IF NOT EXISTS INVENTORY (
                          id INT  PRIMARY KEY NOT NULL,
                          productId INT  NOT NULL,
                          stock INT NOT NULL
);