# Entorno y validación inicial de BarberPro

## 1. Confirmación del repositorio
Se verificó que el repositorio base es:
- `moreraramirezj-creator/barberpro`
- rama de trabajo actual: `docs/specs-initial`

La carpeta actual solo contiene el archivo base `README.md`; el proyecto aún no tiene estructura Maven ni módulos de aplicación.

## 2. Verificación de herramientas Java en el entorno
No se puede afirmar que una herramienta está instalada sin ejecutar el comando correspondiente.

Para validar el entorno local o del servidor, se recomienda ejecutar estas comprobaciones en Linux (Mint o Ubuntu):

```bash
java -version
javac -version
mvn -v
./mvnw -v
```

Si el proyecto usa Gradle, también se debe verificar:

```bash
gradle -v
```

### Recomendación
- Usar Java 11 como base mínima.
- Usar Maven como herramienta principal para este proyecto inicial.
- Si no existe wrapper Maven (`mvnw`), se usará `mvn` instalado en el sistema.

## 3. Estructura Maven propuesta
Se dejó un `pom.xml` base en la raíz del repositorio con esta intención:

```text
pom.xml
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
  test/
    java/
      com/moreraramirezj/barberpro/
```

## 4. Cómo compilar y probar la app Swing
La aplicación continuará siendo un proyecto Java Swing ejecutado como aplicación de escritorio. En esta fase no se implementan módulos funcionales todavía; la estructura está preparada para que luego se completen.

### Ejecutar con Maven
```bash
mvn clean compile
mvn test
mvn exec:java -Dexec.mainClass=com.moreraramirezj.barberpro.app.Main
```

### Generar JAR ejecutable
```bash
mvn clean package
java -jar target/barberpro-0.1.0-SNAPSHOT.jar
```

## 5. Detalle de ejecución en entorno remoto / CI
Si la aplicación se ejecuta en un entorno sin entorno gráfico, se recomienda:
- Probar la lógica de negocio en JUnit sin depender de ventanas Swing.
- Para pruebas de UI reales, usar `xvfb-run` en entornos Linux headless.

Ejemplo:
```bash
xvfb-run -a mvn test
```

## 6. Conservación y recuperación del código
Para mantener el código y poder recuperarlo en Linux Mint:

### Flujo recomendado
```bash
git clone git@github.com:moreraramirezj-creator/barberpro.git
cd barberpro
git checkout docs/specs-initial
git status
git add .
git commit -m "docs: add initial project specification"
git push origin docs/specs-initial
```

### Recuperación de otra máquina
```bash
git fetch --all
git checkout docs/specs-initial
git pull origin docs/specs-initial
```

## 7. Resumen de la etapa actual
La primera fase se ha limitado a:
- confirmar el repositorio y la rama de trabajo,
- dejar una base de estructura Maven,
- documentar la especificación funcional,
- documentar la matriz de trazabilidad,
- plantear la arquitectura por capas,
- dejar indicado cómo compilar, probar y conservar el código.

Esta etapa es una base de diseño y validación antes de abordar los módulos funcionales del sistema.
