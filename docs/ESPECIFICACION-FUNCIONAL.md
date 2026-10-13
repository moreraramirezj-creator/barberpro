# BarberPro — Especificación funcional inicial

## 1. Objetivo
BarberPro es un sistema de gestión para barberías pensado como una aplicación de escritorio con Java Swing.

El alcance inicial (MVP) cubre la operación diaria de una barbería y prioriza funcionalidad operativa sobre complejidad técnica.

## 2. Alcance propuesto para la primera etapa

### 2.1 Módulos funcionales del MVP
- Clientes
  - Registro, edición y búsqueda de clientes.
  - Registro de nombre, teléfono, correo y observaciones.
- Servicios
  - Catálogo de servicios con nombre, duración y precio.
  - Asociación de servicios a citas.
- Citas
  - Agendar, editar y cancelar citas.
  - Validación de horarios y conflictos.
- Calendario semanal y mensual
  - Vista semanal con franjas por horario.
  - Vista mensual para resumen y navegación.
- Lista de espera
  - Registro de clientes pendientes cuando un horario está ocupado.
- Configuración de horario
  - Horario de apertura, cierre y franjas de atención.
- Confirmaciones por correo
  - Envío de recordatorio o confirmación de cita desde una capa de servicio.

### 2.2 Requisitos funcionales preliminares
- RF-001: Registrar un cliente con datos básicos.
- RF-002: Buscar clientes por nombre, teléfono o correo.
- RF-003: Crear y guardar un servicio con precio y duración.
- RF-004: Crear una cita con cliente, servicio, fecha y hora.
- RF-005: Evitar conflictos de horario para la misma barbería.
- RF-006: Consultar calendario semanal y mensual.
- RF-007: Ver y actualizar el estado de una cita.
- RF-008: Registrar un cliente en la lista de espera.
- RF-009: Configurar horarios de atención por día.
- RF-010: Enviar confirmación por correo al crear o modificar una cita.

## 3. Requisitos no funcionales
- Java 11 como línea base recomendada, con compatibilidad 17 en lo posible.
- Interfaz gráfica en Swing.
- Persistencia local con base de datos embebida (recomendado SQLite o H2).
- Arquitectura por capas para separar UI, lógica y persistencia.
- Pruebas automatizadas con JUnit 5.
- Documentación UML y de arquitectura en la carpeta docs/.
- Código reutilizable y extensible, orientado a objetos.

## 4. Criterios de aceptación sugeridos
- Cada requisito funcional debe tener al menos una prueba unitaria o una prueba de integración simple.
- La lógica de negocio no debe depender directamente de Swing.
- La capa de acceso a datos debe ser reemplazable sin tocar la lógica de negocio.
- La configuración del sistema debe poder cambiarse por archivo de propiedades o variables de entorno.

## 5. Supuestos y restricciones
- El proyecto inicia como aplicación local de escritorio, no como sistema web ni multiusuario.
- La persistencia es local y no incluye autenticación ni roles complejos en esta etapa.
- La integración con correo electrónico será una capa simulada o configurable, sin depender del envío real en pruebas automáticas.

## 6. Siguiente paso
Esta especificación es la base para la matriz de trazabilidad y la estructura de módulos que se documentará en `docs/TRAZABILIDAD-MODULOS.md` y `docs/ARQUITECTURA.md`.
