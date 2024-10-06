# Usar una imagen base de Java
FROM openjdk:17-jdk-slim

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar el archivo JAR de tu aplicación a la imagen
COPY target/demo-0.0.1-SNAPSHOT.jar /app/demo.jar

# Exponer el puerto en el que se ejecutará la aplicación
EXPOSE 8081

# Variables de entorno para configurar la base de datos y Keycloak
ENV SPRING_DATASOURCE_URL=jdbc:postgresql://postgres:5432/patientscontrolwithliquibase3
ENV SPRING_DATASOURCE_USERNAME=alejo
ENV SPRING_DATASOURCE_PASSWORD=123456
ENV SPRING_JPA_HIBERNATE_DDL_AUTO=update

ENV KEYCLOAK_HOST=http://keycloak:8080/auth
ENV KEYCLOAK_CLIENTE_REGISTRAR=cliente-registrar
ENV KEYCLOAK_REALM=apipatients
ENV KEYCLOAK_REGISTRO_CLIENT_SECRET=some-secret-value

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app/demo.jar"]
