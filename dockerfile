# Define la imagen base
FROM openjdk:17

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo JAR generado por Gradle al contenedor
COPY build/libs/reactive-web-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto en el que tu aplicación Spring Boot escucha
EXPOSE 8080

# Comando de entrada para ejecutar la aplicación Spring Boot
CMD ["java", "-jar", "app.jar"]