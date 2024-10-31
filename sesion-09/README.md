# Microservicio de Gestión de Órdenes con Patrón SAGA

En este ejercicio, desarrollarás un microservicio para gestionar las órdenes de compra de un ecommerce, utilizando el patrón SAGA con coreografía y Kafka. El microservicio de órdenes se integrará con el microservicio de inventario, permitiendo que cuando se cree una orden, el stock de los productos se verifique, y si no hay suficiente inventario disponible, la orden sea cancelada.

## Requisitos

### 1. Domain Objects
**Orden**  
Cada orden debe tener los siguientes atributos:
- `orderId` (Identificador único, autogenerado)
- `productId` (Identificador del producto, asociado al Producto)
- `quantity` (Cantidad de productos en la orden, entero positivo)
- `status` (Estado de la orden, con los valores: `PENDING`, `COMPLETED`, `CANCELLED`)

### 2. Caso de Uso (Crear Orden)
Implementa un caso de uso que permita:
- Crear una nueva orden con la cantidad de productos solicitada.
- Validar si hay suficiente stock disponible para la cantidad solicitada.
- Si hay suficiente stock, la orden debe marcarse como `COMPLETED`.
- Si no hay suficiente stock, la orden debe marcarse como `CANCELLED` y el stock no debe actualizarse.
- Enviar eventos a través de Kafka para coordinar la transacción entre los microservicios de órdenes e inventario.

### 3. Flujo con Patrón SAGA
Usa el patrón SAGA para gestionar la transacción distribuida entre los microservicios de órdenes e inventario. El flujo debe ser el siguiente:
1. El microservicio de órdenes crea una nueva orden en estado `PENDING` y envía un evento a través de Kafka.
2. El microservicio de inventario recibe el evento y verifica el stock:
    - Si hay suficiente stock, se actualiza el inventario y se envía un evento de éxito (`ORDER_COMPLETED`).
    - Si no hay suficiente stock, se envía un evento de cancelación (`ORDER_CANCELLED`).
3. El microservicio de órdenes recibe el evento y actualiza el estado de la orden a `COMPLETED` o `CANCELLED` según corresponda.

### 4. Infraestructura
- Utiliza una base de datos H2 en memoria para almacenar las órdenes.
- Utiliza Kafka como sistema de mensajería para enviar y recibir eventos entre los microservicios de órdenes e inventario.

### 5. Puertos y Adaptadores
Implementa los puertos de entrada (interfaces de casos de uso) y los puertos de salida (repositorios y adaptadores de mensajería) en la arquitectura hexagonal. Proporciona un adaptador web mediante un controlador REST que exponga los siguientes endpoints:
- `POST /orders` - Crear una nueva orden.
- `GET /orders/{orderId}` - Obtener el estado de una orden.

### 6. Configuración de Kafka en `application.properties` para orders-service
Añade la siguiente configuración para conectar tu aplicación con Kafka en el archivo `application.properties`:

```properties
# Kafka Bootstrap Servers (apuntar a localhost o la IP donde esté Kafka corriendo)
spring.kafka.bootstrap-servers=localhost:9092

# Configuración del productor
spring.kafka.producer.key-serializer=org.apache.kafka.common.serialization.StringSerializer
spring.kafka.producer.value-serializer=org.springframework.kafka.support.serializer.JsonSerializer
spring.kafka.producer.properties.spring.json.add.type.headers=false

# Configuración del consumidor
spring.kafka.consumer.group-id=order-group
spring.kafka.consumer.auto-offset-reset=earliest
spring.kafka.consumer.key-deserializer=org.apache.kafka.common.serialization.StringDeserializer
spring.kafka.consumer.value-deserializer=org.springframework.kafka.support.serializer.JsonDeserializer
spring.kafka.consumer.properties.spring.json.trusted.packages=*

# Configuración del listener de Kafka
spring.kafka.listener.missing-topics-fatal=false
````

### 7. Configuración de Kafka en `application.properties` para inventory-service
Añade la siguiente configuración para conectar tu aplicación con Kafka en el archivo `application.properties`:

```properties
# Kafka Bootstrap Servers (apuntar a localhost o la IP donde esté Kafka corriendo)
spring.kafka.bootstrap-servers=localhost:9092

# Configuración del productor
spring.kafka.producer.key-serializer=org.apache.kafka.common.serialization.StringSerializer
spring.kafka.producer.value-serializer=org.springframework.kafka.support.serializer.JsonSerializer
spring.kafka.producer.properties.spring.json.add.type.headers=false

# Configuración del consumidor
spring.kafka.consumer.group-id=inventory-group
spring.kafka.consumer.auto-offset-reset=earliest
spring.kafka.consumer.key-deserializer=org.apache.kafka.common.serialization.StringDeserializer
spring.kafka.consumer.value-deserializer=org.springframework.kafka.support.serializer.JsonDeserializer
spring.kafka.consumer.properties.spring.json.trusted.packages=*

# Configuración del listener de Kafka
spring.kafka.listener.missing-topics-fatal=false
````

### 8. Script SQL Inicial (base de datos H2)
```sql
-- Insertar productos (ya creados en el microservicio de inventario)

-- Insertar órdenes
INSERT INTO orders (orderId, productId, quantity, status) VALUES (1, 1, 5, 'PENDING');
INSERT INTO orders (orderId, productId, quantity, status) VALUES (2, 2, 3, 'PENDING');
INSERT INTO orders (orderId, productId, quantity, status) VALUES (3, 3, 1, 'PENDING');

````

### 9. Docker-compose para Kafka
```yaml
version: '3.8'
services:
  zookeeper:
    image: bitnami/zookeeper:latest
    container_name: zookeeper
    ports:
      - "2181:2181"
    environment:
      - ALLOW_ANONYMOUS_LOGIN=yes
      - ZOO_CLIENT_PORT=2181

  kafka:
    image: bitnami/kafka:latest
    container_name: kafka
    ports:
      - "9092:9092"
    environment:
      KAFKA_LISTENERS: PLAINTEXT_LOCAL://localhost:9092,PLAINTEXT_DOCKER://kafka:29092
      KAFKA_ADVERTISED_LISTENERS: PLAINTEXT_LOCAL://localhost:9092,PLAINTEXT_DOCKER://kafka:29092
      KAFKA_ZOOKEEPER_CONNECT: zookeeper:2181
      KAFKA_LISTENER_SECURITY_PROTOCOL_MAP: PLAINTEXT_LOCAL:PLAINTEXT,PLAINTEXT_DOCKER:PLAINTEXT
      KAFKA_INTER_BROKER_LISTENER_NAME: PLAINTEXT_DOCKER  # Usar PLAINTEXT_DOCKER para la comunicación entre brokers
    depends_on:
      - zookeeper
    volumes:
      - /var/run/docker.sock:/var/run/docker.sock

  kafdrop:
    image: obsidiandynamics/kafdrop
    restart: "no"
    ports:
      - "9000:9000"
    environment:
      KAFKA_BROKERCONNECT: kafka:29092  # Conexión a través del listener Docker
      JVM_OPTS: "-Xms32M -Xmx64M"
    depends_on:
      - kafka
```

### 10. Instrucciones Finales

- Implementa el microservicio de órdenes utilizando el patrón SAGA, empleando Kafka para la mensajería.
- Asegúrate de que el microservicio de inventario está preparado para interactuar con Kafka y recibir eventos de creación de órdenes.
- Ejecuta las pruebas necesarias para verificar que las órdenes se crean correctamente y que las transacciones son gestionadas adecuadamente a través del patrón SAGA.

