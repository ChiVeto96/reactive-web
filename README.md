# Aplicación Web Básica con Spring WebFlux

Esta es una aplicación web sencilla que expone dos servicios, uno para crear usuarios y otro para obtener información de usuarios.

## Requisitos Previos

Asegúrate de tener instalado lo siguiente:
- Docker
- Java
- Gradlew

## Ejecución

### 1. Clonar el Repositorio
```bash
git clone https://github.com/ChiVeto96/reactive-web.git
```
cd reactive-web
### 2. Compilar la Aplicación
```bash
./gradlew clean build
```
### 3. Construir la Imagen de Docker

```bash
docker build -t  reactive-web .
```

### 4. Ejecutar la Aplicación en Docker

```bash
docker run -p 8080:8080 reactive-web
```

## Uso de la Aplicación

Crear un Usuario
Puedes crear un usuario mediante una solicitud POST a la siguiente URL:
```bash
curl --location 'http://localhost:8080/api/user' \
--header 'Content-Type: application/json' \
--data-raw '{
    "firstName": "Manuel",
    "lastName": "Chitiva",
    "email": "mschitiva68@gmail.com",
    "cellPhone": 3214424552
}'
```
Consultar los usuarios registrados

Puedes extraer la data completa mediante una solicitud GET a la siguiente URL:
```bash
curl --location 'localhost:8080/api/user'
```

Consultar por email
```bash
curl --location 'localhost:8080/api/user/find?email=jero%40gmail.com'
```

### 5. URL SWAGGER
```bash
http://localhost:8080/webjars/swagger-ui/index.html#/user-controller/create
```


NOTA : No utilice  Flyway  en MongoDB, ya que MongoDB no se basa en un esquema fijo y no necesita migraciones de esquema tradicionales.
En cambio, enfócate en el control de versiones, pruebas y documentación de tus cambios en la base de datos MongoDB de una manera adecuada a las necesidades y características de MongoDB.

