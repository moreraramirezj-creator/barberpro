# Matriz de trazabilidad: requisitos, módulos y pruebas

La siguiente matriz sirve como base para mantener la trazabilidad del MVP de BarberPro.

| ID | Requisito funcional | Módulo principal | Capa de implementación | Tipo de prueba recomendado | Estado |
|---|---|---|---|---|---|
| RF-001 | Registrar cliente | clientes | model + service + persistence | Unitario | Pendiente |
| RF-002 | Buscar y listar clientes | clientes | service + repository | Unitario | Pendiente |
| RF-003 | Registrar servicio | servicios | model + service + persistence | Unitario | Pendiente |
| RF-004 | Crear cita | citas | service + persistence | Unitario | Pendiente |
| RF-005 | Validar conflictos de horario | citas | service | Unitario | Pendiente |
| RF-006 | Consultar calendario semanal | calendario | service + ui | Unitario / integración | Pendiente |
| RF-007 | Consultar calendario mensual | calendario | service + ui | Unitario / integración | Pendiente |
| RF-008 | Cambiar estado de cita | citas | service | Unitario | Pendiente |
| RF-009 | Registrar en lista de espera | lista_espera | service + persistence | Unitario | Pendiente |
| RF-010 | Configurar horario de atención | configuracion | service + persistence | Unitario | Pendiente |
| RF-011 | Enviar confirmación por correo | email | service + infra | Unitario con mock | Pendiente |

## Módulos esperados
- `com.moreraramirezj.barberpro.model`
- `com.moreraramirezj.barberpro.service`
- `com.moreraramirezj.barberpro.persistence`
- `com.moreraramirezj.barberpro.ui`
- `com.moreraramirezj.barberpro.controller`
- `com.moreraramirezj.barberpro.config`
- `com.moreraramirezj.barberpro.infra`

## Recomendación para pruebas
- Los tests deben cubrir la lógica de negocio, no la lógica visual.
- Las pruebas de UI deben limitarse a validación muy básica o a casos manuales documentados.
- El uso de mocks en servicios de correo y persistencia reduce riesgo y acelera validación.
