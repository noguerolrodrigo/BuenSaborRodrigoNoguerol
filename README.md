# Proyecto Final - Buen Sabor 🍽️

Este proyecto es una simulación de sistema de pedidos para un local gastronómico, desarrollado en Java con Gradle, Lombok y JPA (estructurado).

---

## 🔧 Tecnologías utilizadas

- **Java 17**
- **Gradle**
- **Lombok**
- **JPA (estructura anotada)**
- **Git y GitHub**

---

## 📦 Estructura del proyecto

- `App` → contiene el `Main.java`
- `Entities` → modelo de negocio (consumidores, productos, orden, etc.)
- `Enums` → enumeraciones como estado, forma de pago, tipo de envío
- `DAO` → capa de acceso a datos simulada (`EmpresaDAO`)

---

## ✅ Funcionalidades implementadas

- Registro de consumidores y órdenes
- Asignación de repartidor a pedidos
- Sistema de feedback con puntuación
- Pruebas funcionales del DAO (`EmpresaDAO`)
- Impresión de resultados en consola
- Uso de enums extendidos (formas de pago)
- Renombrado y personalización total del modelo

---

## 🧱 Clases personalizadas agregadas

- `Repartidor` → persona que entrega los pedidos
- `Feedback` → opinión y puntuación del cliente
- `EmpresaDAO` → lógica de acceso a datos simulada
- `Chef` (opcional) → cocinero del pedido

---

## 🧪 Pruebas realizadas

Desde el `Main.java` se instancian todas las clases y se simula un flujo completo de pedido, entrega, feedback y gestión de empresas con DAO.

---

## 👤 Autor

**Rodrigo Noguerol**