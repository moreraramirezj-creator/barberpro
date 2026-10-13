# Arquitectura propuesta para BarberPro

## 1. Objetivo de la arquitectura
La arquitectura de BarberPro deberá permitir una evolución ordenada desde un MVP de escritorio hasta una aplicación más compleja, sin mezclar lógica de negocio con Swing ni con acceso a datos.

## 2. Capas recomendadas

### 2.1 Capa de modelo
Responsable de representar entidades del dominio:
- Cliente
- Servicio
- Cita
- Horario
- ListaEspera
- ConfiguracionBarberia

Paquete sugerido:
- `com.moreraramirezj.barberpro.model`

### 2.2 Capa de servicio
Responsable de la lógica de negocio:
- alta/baja/modificación de clientes
- creación de citas
- validación de conflictos de horario
- cálculo de calendario
- gestión de lista de espera
- confirmaciones por email

Paquete sugerido:
- `com.moreraramirezj.barberpro.service`

### 2.3 Capa de persistencia
Responsable de acceso a la base de datos local:
- DAO/Repository para cada entidad
- lectura y escritura de registros
- scripts de inicialización

Paquetes sugeridos:
- `com.moreraramirezj.barberpro.persistence`
- `com.moreraramirezj.barberpro.config`

### 2.4 Capa de UI (Swing)
Responsable de la representación visual:
- formularios
- tablas
- paneles del calendario
- diálogos de edición

Paquetes sugeridos:
- `com.moreraramirezj.barberpro.ui`
- `com.moreraramirezj.barberpro.controller`

### 2.5 Infraestructura transversal
Responsable de utilidades compartidas:
- logging
- configuración
- envío de correo
- validación

Paquete sugerido:
- `com.moreraramirezj.barberpro.infra`

## 3. Patrón recomendado
Se recomienda una separación similar a MVC o a una variante simple de capas:
- Vista (Swing)
- Controlador (intermediario entre vista y servicios)
- Servicio (reglas de negocio)
- Repositorio/DAO (persistencia)

Esto favorece la prueba unitaria y evita acoplar la lógica con la interfaz gráfica.

## 4. Estructura inicial de directorios propuesta
```text
src/
  main/
    java/
      com/moreraramirezj/barberpro/
        app/
        model/
        service/
        persistence/
        controller/
        ui/
        config/
        infra/
    resources/
      application.properties
      db/
        schema.sql
        data.sql
  test/
    java/
      com/moreraramirezj/barberpro/
        service/
        persistence/
```

## 5. Recomendación de persistencia
Para una primera implementación local, se sugiere SQLite por su simplicidad y por ser adecuado para un entorno de escritorio sin servidor externo.

Alternativas válidas:
- SQLite (recomendada para MVP)
- H2 (útil para pruebas y despliegue local)

## 6. Recomendación UML
En esta primera etapa se recomienda documentar:
- Diagrama de clases del dominio
- Diagrama de casos de uso de negocio
- Diagrama de secuencia para "crear una cita"

Los diagramas pueden producirse con PlantUML o con herramientas de UML del IDE.
