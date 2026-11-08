# API REST de Gestión de Usuarios

API REST desarrollada con **Spring Boot 3** y **Java** para la gestión de usuarios, utilizando **Spring Data JPA** y **MySQL** como motor de base de datos.

---

## 🛠️ Tecnologías Utilizadas

- **Java 17** (o superior)
- **Spring Boot 3**
- **Spring Data JPA**
- **MySQL Server**
- **Lombok**
- **Maven**

---

## 📋 Requisitos Previos

Antes de ejecutar el proyecto, asegúrate de tener instalado:

1. **JDK 17** o superior configurado en las variables de entorno.
2. **MySQL Server** en ejecución (local o mediante contenedor).
3. **Maven** (opcional si usas el wrapper incluido `./mvnw`).

---

## 🗄️ Base de Datos

Crea la base de datos en tu servidor MySQL antes de iniciar la aplicación:

```sql
CREATE DATABASE bd_fullstack;
```

---

## ⚙️ Configuración (`application.properties`)

Asegúrate de que el archivo `src/main/resources/application.properties` tenga las credenciales correctas de tu MySQL local:

```properties
# Servidor y Puerto
server.port=8080

# Conexión a MySQL
spring.datasource.url=jdbc:mysql://localhost:3306/bd_fullstack?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
spring.datasource.username=root
spring.datasource.password=tu_contraseña
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# JPA / Hibernate
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

---

## 🚀 Ejecución del Proyecto

1. **Clonar el repositorio:**
   ```bash
   git clone <URL_DE_TU_REPOSITORIO>
   cd <NOMBRE_DEL_PROYECTO>
   ```

2. **Compilar y ejecutar la aplicación:**
   ```bash
   ./mvnw spring-boot:run
   ```
   *(En Windows puedes usar `mvnw.cmd spring-boot:run` o ejecutar directamente desde tu IDE).*

3. La API estará disponible por defecto en: `http://localhost:8080/usuarios`

---

## 📦 Carga Inicial de Datos

Al iniciar por primera vez, la aplicación ejecuta automáticamente un `CommandLineRunner` que inserta los siguientes usuarios de prueba si la base de datos está vacía:

| ID | Nombre | Apellido | Edad | Tipo |
|---|---|---|---|---|
| `1` | Carlos | Muñoz | 32 | vip |
| `2` | María | Urrutia | 26 | vip |
| `3` | Antonia | Saez | 25 | regular |

---

## 📡 Endpoints de la API

| Método | Endpoint | Descripción | Estado HTTP Exitoso |
| :--- | :--- | :--- | :--- |
| **GET** | `/usuarios` | Obtiene el listado completo de usuarios | `200 OK` |
| **GET** | `/usuarios/{id}` | Obtiene un usuario específico por ID | `200 OK` / `404 Not Found` |
| **POST** | `/usuarios` | Crea un nuevo usuario | `201 Created` |
| **PUT** | `/usuarios/{id}` | Actualiza los datos de un usuario por ID | `200 OK` / `404 Not Found` |
| **DELETE** | `/usuarios/{id}` | Elimina un usuario por ID | `204 No Content` / `404 Not Found` |

---

## 📝 Ejemplos de Peticiones JSON

### **POST /usuarios** (Crear usuario)
```json
{
  "nombre": "Pedro",
  "apellido": "Soto",
  "edad": 28,
  "tipo": "regular"
}
```

### **PUT /usuarios/1** (Actualizar usuario)
```json
{
  "nombre": "Carlos",
  "apellido": "Muñoz Perez",
  "edad": 33,
  "tipo": "vip"
}
```