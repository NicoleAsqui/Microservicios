# Tienda Monorepo

Este repositorio contiene la implementación del back-end de una aplicación web basada en microservicios para una tienda de libros. La arquitectura sigue los principios de Spring Cloud, incluyendo Eureka para el descubrimiento de servicios y Spring Cloud Gateway como punto de entrada único.

## Estructura del Proyecto

El proyecto está organizado en los siguientes módulos:

1. **`ms-books-catalogue`**: Microservicio encargado de gestionar el catálogo de libros.
2. **`ms-books-payments`**: Microservicio encargado de gestionar los pagos y compras de libros.
3. **`eureka-server`**: Servidor de descubrimiento para registrar y localizar microservicios.
4. **`api-gateway`**: API Gateway que actúa como punto de entrada único para todas las solicitudes del cliente.

## Requisitos

- Java 17.
- Maven 3.x.
- IDE (IntelliJ IDEA, Eclipse, VS Code, etc.).
- Docker (opcional, para despliegue en contenedores).

## Configuración

1. Clona el repositorio:
   ```bash
   git clone https://github.com/tu-usuario/tienda-monorepo.git