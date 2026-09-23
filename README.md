# Proyecto Login y Registro

Este repositorio contiene dos proyectos principales:

- `first-project`: frontend en React + Vite
- `registrolps`: backend en Spring Boot

## Estructura

```text
drive/
├── first-project/
│   ├── src/
│   ├── package.json
│   ├── vite.config.js
│   └── ...
├── registrolps/
│   ├── src/
│   ├── pom.xml
│   ├── mvnw
│   └── ...
└── README.md
```

## Requisitos

- Node.js 18+
- Java 21
- MySQL
- Git

## Frontend

1. Abre la terminal en `first-project`
2. Instala dependencias:

```bash
npm install
```

3. Ejecuta la app:

```bash
npm run dev
```

4. La app queda disponible normalmente en:

```text
http://localhost:5173
```

## Backend

1. Asegúrate de tener MySQL corriendo.
2. Crea la base de datos `registro`.
3. Ajusta credenciales si es necesario en:

```yaml
registrolps/src/main/resources/application.yaml
```

4. Desde la carpeta `registrolps`, ejecuta:

```bash
./mvnw spring-boot:run
```

5. La API queda en:

```text
http://localhost:8080
```

## Login

La autenticación usa:

- `usuario`
- `password` (campo `ctrs` desde el frontend)
- `tipo`

Flujo esperado:

- Credenciales incorrectas -> muestra mensaje de error
- Credenciales correctas -> redirige a `/inicio`

## GitHub

Repositorio actual:

```text
https://github.com/nathSD/first-proyect.git
```
