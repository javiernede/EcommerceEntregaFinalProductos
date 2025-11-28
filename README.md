# 🛒 Ecommerce - Gestión de Productos (Spring Boot)

Aplicación backend desarrollada en **Spring Boot** que permite gestionar productos con operaciones CRUD.  
Incluye integración con **MySQL**, uso de **DTOs**, **Mapper**, manejo de excepciones personalizado y arquitectura en capas.

---

## 🚀 Tecnologías utilizadas

- **Java 17**
- **Spring Boot 3**
- **Spring Web**
- **Spring Data JPA**
- **MySQL**
- **Lombok**
- **Swagger / OpenAPI**
- **GitHub Desktop**

---

## 📦 Funcionalidades

✔ Listar productos  
✔ Obtener un producto por ID  
✔ Crear productos  
✔ Actualizar productos  
✔ Eliminar productos  
✔ Validación de datos  
✔ Excepción personalizada `ProductoNotFoundException`  
✔ Uso de DTOs:
- `ProductoDTO`
- `ProductoCreateDTO`
- `ProductoUpdateDTO`

---

## 🧱 Arquitectura del proyecto

src/main/java/com.ecommerce.productos/
│
├── controller → Endpoints REST
├── entity → Entidades JPA
├── service → Interfaces de servicio
├── serviceimpl → Implementaciones
├── repository → Acceso a datos
├── dto → Objetos de transferencia
├── mapper → Conversión Entity ↔ DTO
└── exception → Manejo de errores
