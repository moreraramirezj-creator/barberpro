CREATE TABLE IF NOT EXISTS clientes (
    id TEXT PRIMARY KEY,
    nombre TEXT NOT NULL,
    telefono TEXT NOT NULL,
    correo TEXT,
    observaciones TEXT
);

CREATE TABLE IF NOT EXISTS servicios (
    id TEXT PRIMARY KEY,
    nombre TEXT NOT NULL,
    duracion_minutos INTEGER NOT NULL,
    precio NUMERIC NOT NULL
);

CREATE TABLE IF NOT EXISTS citas (
    id TEXT PRIMARY KEY,
    cliente_id TEXT NOT NULL,
    servicio_id TEXT NOT NULL,
    fecha_hora TEXT NOT NULL,
    estado TEXT NOT NULL
);
