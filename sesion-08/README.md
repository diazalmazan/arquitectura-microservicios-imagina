# Ejercicio: Creación de un Microservicio desde Cero con Arquitectura Hexagonal en un Contexto de Ecommerce

En este ejercicio, desarrollarás un microservicio desde cero utilizando **Spring Boot** y aplicando los principios de la **Arquitectura Hexagonal**. El objetivo será construir un microservicio que gestione el inventario de productos de un ecommerce, permitiendo actualizar las existencias de productos. El microservicio gestionará tanto los productos como las líneas de inventario, y los agregados estarán compuestos por ambos.

## Requisitos

### 1. Domain Objects

#### Producto
Cada producto debe tener los siguientes atributos:
- `id` (Identificador único, autogenerado)
- `name` (Nombre del producto, cadena de texto)
- `price` (Precio del producto, número decimal)
- `description` (Descripción del producto, cadena de texto)

#### Línea de Inventario
Cada línea de inventario debe tener los siguientes atributos:
- `inventoryId` (Identificador único, autogenerado)
- `productId` (Identificador del producto, asociado al Producto)
- `stock` (Cantidad disponible en el inventario, entero positivo)

### 2. Agregado (Inventario como Agregado Raíz)
- El **Agregado Inventario** será el encargado de gestionar la relación entre un **Producto** y su **Línea de Inventario**.
- Reglas de negocio a implementar:
  - No se puede actualizar el stock a un valor negativo.
  - El precio del producto debe ser mayor a cero.
  - Cada línea de inventario está asociada a un producto único.

### 3. Caso de Uso (Actualizar Inventario)
Implementa un caso de uso que permita:
- Actualizar el stock de un producto existente.
- Validar las reglas de negocio antes de persistir cualquier cambio.
- Si el producto no existe, el sistema debe devolver un error.

### 4. Infraestructura
- Utiliza una base de datos **H2 en memoria** para almacenar los productos y las líneas de inventario.
- Proporciona un script SQL que cargue algunos productos y líneas de inventario iniciales al iniciar la aplicación.

### 5. Puertos y Adaptadores
- Implementa los **puertos de entrada** (interfaces de casos de uso) y los **puertos de salida** (repositorios) en la arquitectura hexagonal.
- Proporciona un **adaptador web** mediante un controlador REST que exponga los siguientes endpoints:
  - `GET /products` - Listar todos los productos.
  - `PUT /inventory/{id}/stock` - Actualizar el stock de una línea de inventario asociada a un producto.

### 6. Script SQL Inicial (base de datos H2)
```sql
-- Insertar productos
INSERT INTO product (id, name, price, description) VALUES (1, 'Laptop', 1200.00, 'Laptop de gama alta');
INSERT INTO product (id, name, price, description) VALUES (2, 'Headphones', 150.00, 'Auriculares inalámbricos');
INSERT INTO product (id, name, price, description) VALUES (3, 'Keyboard', 75.00, 'Teclado mecánico');

-- Insertar líneas de inventario
INSERT INTO inventory (inventoryId, productId, stock) VALUES (1, 1, 50);
INSERT INTO inventory (inventoryId, productId, stock) VALUES (2, 2, 200);
INSERT INTO inventory (inventoryId, productId, stock) VALUES (3, 3, 100);
