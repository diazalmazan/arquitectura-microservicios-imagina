# Usa una imagen de JRE para ejecutar la aplicación
FROM eclipse-temurin:17-jre

# Directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo JAR al contenedor (ajusta el nombre del JAR si es necesario)
COPY target/*.jar app.jar

# Exponer el puerto de la aplicación (ajusta si es diferente)
EXPOSE 8081

# Comando para ejecutar la aplicación Spring Boot
ENTRYPOINT ["java", "-jar", "app.jar"]
